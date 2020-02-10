package com.example.OSRSCOMPANION.models.databuilder;

import com.example.OSRSCOMPANION.models.constants.*;

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

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<skillData> skillInfo = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<data> data = new ArrayList<>();

    private boolean isRecent = true;

    private boolean isNormal = false;

    private boolean isHardcore = false;

    private boolean isIronman = false;

    private boolean isUltimate = false;

    private Timestamp dataTimeStamp = new Timestamp(System.currentTimeMillis());

    private Integer type;

    //|||CONSTRUCTORS|||

    //empty
    public DataPoint(){ }
    //constructor if just display name is given (defaults to default hiscores)
    public DataPoint(String displayName, String hiscoreName, HttpsURLConnection connection,Boolean isNormal,Boolean isIronman,Boolean isUltimate, Boolean isHardcore,Integer type) {

        ArrayList<Long> dataArrayLongs = new ArrayList<Long>();

        this.isNormal = isNormal;
        this.isIronman = isIronman;
        this.isUltimate = isUltimate;
        this.isHardcore = isHardcore;
        this.type = type;


        try {
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                //reads the data line by line for me, kinda clunky to work with
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                //manipulates the data out of String form and places each value into an easy to
                //use array of all 179 values
                while ((inputLine = in.readLine()) != null) {
                    StringBuffer response = new StringBuffer(inputLine);
                    String[] dataArray = response.toString().split(",");
                    for (int i = 0; i < dataArray.length; i++) {
                        dataArrayLongs.add(Long.parseLong(dataArray[i]));
                    }
                }

                in.close();

                //rank
                //level
                //experience
                //skillname

                int dataPlaceValue = 0;
                for (skillNames skill : skillNames.values()){
                    skillInfo.add(new skillData(dataArrayLongs.get(dataPlaceValue), dataArrayLongs.get(dataPlaceValue+1), dataArrayLongs.get(dataPlaceValue+2),skill.getSkillName()));
                    dataPlaceValue += 3;
                }
                for (dataTypes dataType : dataTypes.values()){
                    for (int i = 0; i <= getDataType(dataType.getTypeNumber()).length; i++)

                }
                if (dataPlaceValue == 72 || dataPlaceValue == 73){
                    if(dataArrayLongs.get(72) != -1 || dataArrayLongs.get(73) != -1){
                        System.out.println("DATAPOINTS 72 or 73 filled - investigate");
                    }
                    dataPlaceValue = 74;
                }
                for (bountyNames name : bountyNames.values()){
                    bountyInfo.add(new bountyData(name.bountyName,dataArrayLongs.get(dataPlaceValue),dataArrayLongs.get(dataPlaceValue+1)));
                    dataPlaceValue += 2;
                }
                for (clueNames clue : clueNames.values()){
                    clueInfo.add(new clueData(clue.getClueType(),dataArrayLongs.get(dataPlaceValue),dataArrayLongs.get(dataPlaceValue+1)));
                    dataPlaceValue += 2;
                }
                if (i == 92 || i == 93){
                    lmsInfo.add(new lmsData(dataArrayLongs.get(dataPlaceValue),dataArrayLongs.get(dataPlaceValue+1)));
                    dataPlaceValue += 2;
                }
                for (bossNames boss : bossNames.values()){
                    bossInfo.add(new bossData(boss.getBossName(),boss.getBossNumber(),dataArrayLongs.get(dataPlaceValue),dataArrayLongs.get(dataPlaceValue+1)));
                    dataPlaceValue += 2;
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

    public skillNames[] getDataType(Integer typeNumber){
        switch(typeNumber){
            case (0):
                return skillNames.values();
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
            System.out.println("Finished.");
        }
        return null;
    }

    //|||ACCESSORS|||

    public boolean getIsNormal() {
        return this.isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }

    public boolean getIsHardcore() {
        return isHardcore;
    }

    public void setHardcore(boolean hardcore) {
        isHardcore = hardcore;
    }

    public boolean getIsIronman() {
        return isIronman;
    }

    public void setIronman(boolean ironman) {
        isIronman = ironman;
    }

    public boolean getIsUltimate() {
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

    public List<skillData> getSkillInfo(){
        return skillInfo;
    }

    public void setSkillInfo(List<skillData> skillInfo) {
        this.skillInfo = skillInfo;
    }

    public Integer getType(){
        return this.type;
    }

    private void setType(Integer type){
        this.type = type;
    }

    public List<data> getData() {
        return data;
    }

    public void setClueInfo(List<data> data) {
        this.data = data;
    }


}
