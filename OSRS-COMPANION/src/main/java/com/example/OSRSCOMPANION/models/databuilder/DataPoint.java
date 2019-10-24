package com.example.OSRSCOMPANION.models.databuilder;

import com.example.OSRSCOMPANION.models.constants.skillNames;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class DataPoint {
    //properties
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<skillData> skillInfo = new ArrayList<>();

    //not currently used
    //kept if I decide to use at some point
    private boolean isRecent = true;

    private boolean isNormal = false;

    private boolean isHardcore = false;

    private boolean isIronman = false;

    private boolean isUltimate = false;

    private Timestamp dataTimeStamp = new Timestamp(System.currentTimeMillis());
    //constructors
    //empty
    public DataPoint(){ }
    //constructor if just display name is given (defaults to default hiscores)
    public DataPoint(String displayName, String hiscoreName, HttpsURLConnection connection,Boolean isNormal,Boolean isIronman,Boolean isUltimate, Boolean isHardcore) {

        ArrayList<Long> dataArrayLongs = new ArrayList<Long>();

        this.isNormal = isNormal;
        this.isIronman = isIronman;
        this.isUltimate = isUltimate;
        this.isHardcore = isHardcore;


        try {
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                //reads the data line by line for me, kinda clunky to work with
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                //manipulates the data out of String form and places each value into an easy to
                //use array of all values
                while ((inputLine = in.readLine()) != null) {
                    StringBuffer response = new StringBuffer(inputLine);
                    String[] dataArray = response.toString().split(",");
                    for (int i = 0; i < dataArray.length; i++) {
                        dataArrayLongs.add(Long.parseLong(dataArray[i]));
                    }
                }

                in.close();

                //test
                System.out.println(dataArrayLongs.get(0));
                System.out.println(dataArrayLongs.get(1));
                System.out.println(dataArrayLongs.get(2));
                System.out.println(dataArrayLongs.get(3));
                System.out.println(dataArrayLongs.get(4));
                System.out.println(dataArrayLongs.get(5));
                //end test

                //rank
                //level
                //experience
                //skillname

                int i = 0;
                for (skillNames skill : skillNames.values()){
                    skillInfo.add(new skillData(dataArrayLongs.get(i), dataArrayLongs.get(i+1), dataArrayLongs.get(i+2),skill.getSkillName()));
                    i += 3;
                }

                this.dataTimeStamp = new Timestamp(System.currentTimeMillis());

                System.out.println(this.dataTimeStamp.getTime());
            } else {
                System.out.println("Not featured on hiscore");
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {

        }
    }

    //method for base(normal account) url building (used in constructor)
    static public String buildUrlString(String displayName){
        String urlString = String.format("https://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=%1$s",displayName.replaceAll(" ", "_"));
        System.out.println(urlString);
        return urlString;

    }

    //method for calling special hiscores(ironman,ultimate,hardcore) I don't plan on adding support for seasonal initially anyway (used in constructor)
    static public String buildUrlString(String hiscoreName,String displayName){

        String urlString = String.format("https://services.runescape.com/m=hiscore_oldschool%1$s/index_lite.ws?player=%2$s",hiscoreName,displayName.replaceAll(" ", "_"));
        System.out.println(urlString);
        return urlString;
    }

    static public HttpsURLConnection buildResponse(String displayName,String hiscoreName){
        try {
        //url creation
        String url = buildUrlString(hiscoreName,displayName);
        URL obj = new URL(url);
        //connection setup
        HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished, I can't help you.");
        }
        return null;
    }

    //accessors


    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }

    public boolean isHardcore() {
        return isHardcore;
    }

    public void setHardcore(boolean hardcore) {
        isHardcore = hardcore;
    }

    public boolean isIronman() {
        return isIronman;
    }

    public void setIronman(boolean ironman) {
        isIronman = ironman;
    }

    public boolean isUltimate() {
        return isUltimate;
    }

    public void setUltimate(boolean ultimate) {
        isUltimate = ultimate;
    }

    public void setIsRecent(Boolean isRecent){this.isRecent = isRecent;}

    public boolean getIsRecent(){return this.isRecent;}

    public int getId() {
        return id;
    }

    public Timestamp getDataTimeStamp() {
        return dataTimeStamp;
    }

    public List getSkillInfo(){
        return skillInfo;
    }
}
