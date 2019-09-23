package com.example.OSRSCOMPANION.models.databuilder;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private boolean isNormal;

    private boolean isHardcore;

    private boolean isIronman;

    private boolean isUltimate;

    //skill properties
    private int totalRank;
    private int totalExperience;
    private int totalLevel;

    private int attackRank;
    private int attackExperience;
    private int attackLevel;

    private int defenceRank;
    private int defenceExperience;
    private int defenceLevel;

    private int strengthRank;
    private int strengthExperience;
    private int strengthLevel;

    private int hitpointsRank;
    private int hitpointsExperience;
    private int hitpointsLevel;

    private int rangedRank;
    private int rangedExperience;
    private int rangedLevel;

    private int prayerRank;
    private int prayerExperience;
    private int prayerLevel;

    private int magicRank;
    private int magicExperience;
    private int magicLevel;

    private int cookingRank;
    private int cookingExperience;
    private int cookingLevel;

    private int woodcuttingRank;
    private int woodcuttingExperience;
    private int woodcuttingLevel;

    private int fletchingRank;
    private int fletchingExperience;
    private int fletchingLevel;

    private int fishingRank;
    private int fishingExperience;
    private int fishingLevel;

    private int firemakingRank;
    private int firemakingExperience;
    private int firemakingLevel;

    private int craftingRank;
    private int craftingExperience;
    private int craftingLevel;

    private int smithingRank;
    private int smithingExperience;
    private int smithingLevel;

    private int miningRank;
    private int miningExperience;
    private int miningLevel;

    private int herbloreRank;
    private int herbloreExperience;
    private int herbloreLevel;

    private int agilityRank;
    private int agilityExperience;
    private int agilityLevel;

    private int thievingRank;
    private int thievingExperience;
    private int thievingLevel;

    private int slayerRank;
    private int slayerExperience;
    private int slayerLevel;

    private int farmingRank;
    private int farmingExperience;
    private int farmingLevel;

    private int runecraftingRank;
    private int runecraftingExperience;
    private int runecraftingLevel;

    private int hunterRank;
    private int hunterExperience;
    private int hunterLevel;

    private int constructionRank;
    private int constructionExperience;
    private int constructionLevel;

    private Timestamp dataTimeStamp = new Timestamp(System.currentTimeMillis());
    //constructors
    //empty
    public DataPoint(){ }
    //constructor if just display name is given (defaults to default hiscores)
    public DataPoint(String displayName, String hiscoreName, HttpsURLConnection connection) {

        ArrayList<Integer> dataArrayInts = new ArrayList<Integer>();

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
                        dataArrayInts.add(Integer.parseInt(dataArray[i]));
                    }
                }

                in.close();

                //test
                System.out.println(dataArrayInts.get(0));
                System.out.println(dataArrayInts.get(1));
                System.out.println(dataArrayInts.get(2));
                System.out.println(dataArrayInts.get(3));
                System.out.println(dataArrayInts.get(4));
                System.out.println(dataArrayInts.get(5));
                //rank
                //level
                //experience

                this.totalRank = dataArrayInts.get(0);
                this.totalLevel = dataArrayInts.get(1);
                this.totalExperience = dataArrayInts.get(2);

                this.attackRank = dataArrayInts.get(3);
                this.attackLevel = dataArrayInts.get(4);
                this.attackExperience = dataArrayInts.get(5);

                this.defenceRank = dataArrayInts.get(6);
                this.defenceLevel = dataArrayInts.get(7);
                this.defenceExperience = dataArrayInts.get(8);

                this.strengthRank = dataArrayInts.get(9);
                this.strengthLevel = dataArrayInts.get(10);
                this.strengthExperience = dataArrayInts.get(11);

                this.hitpointsRank = dataArrayInts.get(12);
                this.hitpointsLevel = dataArrayInts.get(13);
                this.hitpointsExperience = dataArrayInts.get(14);

                this.rangedRank = dataArrayInts.get(15);
                this.rangedLevel = dataArrayInts.get(16);
                this.rangedExperience = dataArrayInts.get(17);

                this.prayerRank = dataArrayInts.get(18);
                this.prayerLevel = dataArrayInts.get(19);
                this.prayerExperience = dataArrayInts.get(20);

                this.magicRank = dataArrayInts.get(21);
                this.magicLevel = dataArrayInts.get(22);
                this.magicExperience = dataArrayInts.get(23);

                this.cookingRank = dataArrayInts.get(24);
                this.cookingLevel = dataArrayInts.get(25);
                this.cookingExperience = dataArrayInts.get(26);

                this.woodcuttingRank = dataArrayInts.get(27);
                this.woodcuttingLevel = dataArrayInts.get(28);
                this.woodcuttingExperience = dataArrayInts.get(29);

                this.fletchingRank = dataArrayInts.get(30);
                this.fletchingLevel = dataArrayInts.get(31);
                this.fletchingExperience = dataArrayInts.get(32);

                this.fishingRank = dataArrayInts.get(33);
                this.fishingLevel = dataArrayInts.get(34);
                this.fishingExperience = dataArrayInts.get(35);

                this.firemakingRank = dataArrayInts.get(36);
                this.firemakingLevel = dataArrayInts.get(37);
                this.firemakingExperience = dataArrayInts.get(38);

                this.craftingRank = dataArrayInts.get(39);
                this.craftingLevel = dataArrayInts.get(40);
                this.craftingExperience = dataArrayInts.get(41);

                this.smithingRank = dataArrayInts.get(42);
                this.smithingLevel = dataArrayInts.get(43);
                this.smithingExperience = dataArrayInts.get(44);

                this.miningRank = dataArrayInts.get(45);
                this.miningLevel = dataArrayInts.get(46);
                this.miningExperience = dataArrayInts.get(47);

                this.herbloreRank = dataArrayInts.get(48);
                this.herbloreLevel = dataArrayInts.get(49);
                this.herbloreExperience = dataArrayInts.get(50);

                this.agilityRank = dataArrayInts.get(51);
                this.agilityLevel = dataArrayInts.get(52);
                this.agilityExperience = dataArrayInts.get(53);

                this.thievingRank = dataArrayInts.get(54);
                this.thievingLevel = dataArrayInts.get(55);
                this.thievingExperience = dataArrayInts.get(56);

                this.slayerRank = dataArrayInts.get(57);
                this.slayerLevel = dataArrayInts.get(58);
                this.slayerExperience = dataArrayInts.get(59);

                this.farmingRank = dataArrayInts.get(60);
                this.farmingLevel = dataArrayInts.get(61);
                this.farmingExperience = dataArrayInts.get(62);

                this.runecraftingRank = dataArrayInts.get(63);
                this.runecraftingLevel = dataArrayInts.get(64);
                this.runecraftingExperience = dataArrayInts.get(65);

                this.hunterRank = dataArrayInts.get(66);
                this.hunterLevel = dataArrayInts.get(67);
                this.hunterExperience = dataArrayInts.get(68);

                this.constructionRank = dataArrayInts.get(69);
                this.constructionLevel = dataArrayInts.get(70);
                this.constructionExperience = dataArrayInts.get(71);

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
        String urlString = String.format("https://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=%1$s",displayName);
        System.out.println(urlString);
        return urlString;

    }

    //method for calling special hiscores(ironman,ultimate,hardcore) I don't plan on adding support for seasonal initially anyway (used in constructor)
    static public String buildUrlString(String hiscoreName,String displayName){
        String urlString = String.format("https://services.runescape.com/m=hiscore_oldschool%1$s/index_lite.ws?player=%2$s",hiscoreName,displayName);
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


    public int getId() {
        return id;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public int getTotalExperience() {
        return totalExperience;
    }

    public int getTotalLevel() {
        return totalLevel;
    }

    public int getAttackRank() {
        return attackRank;
    }

    public int getAttackExperience() {
        return attackExperience;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public int getDefenceRank() {
        return defenceRank;
    }

    public int getDefenceExperience() {
        return defenceExperience;
    }

    public int getDefenceLevel() {
        return defenceLevel;
    }

    public int getStrengthRank() {
        return strengthRank;
    }

    public int getStrengthExperience() {
        return strengthExperience;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public int getHitpointsRank() {
        return hitpointsRank;
    }

    public int getHitpointsExperience() {
        return hitpointsExperience;
    }

    public int getHitpointsLevel() {
        return hitpointsLevel;
    }

    public int getRangedRank() {
        return rangedRank;
    }

    public int getRangedExperience() {
        return rangedExperience;
    }

    public int getRangedLevel() {
        return rangedLevel;
    }

    public int getPrayerRank() {
        return prayerRank;
    }

    public int getPrayerExperience() {
        return prayerExperience;
    }

    public int getPrayerLevel() {
        return prayerLevel;
    }

    public int getMagicRank() {
        return magicRank;
    }

    public int getMagicExperience() {
        return magicExperience;
    }

    public int getMagicLevel() {
        return magicLevel;
    }

    public int getCookingRank() {
        return cookingRank;
    }

    public int getCookingExperience() {
        return cookingExperience;
    }

    public int getCookingLevel() {
        return cookingLevel;
    }

    public int getWoodcuttingRank() {
        return woodcuttingRank;
    }

    public int getWoodcuttingExperience() {
        return woodcuttingExperience;
    }

    public int getWoodcuttingLevel() {
        return woodcuttingLevel;
    }

    public int getFletchingRank() {
        return fletchingRank;
    }

    public int getFletchingExperience() {
        return fletchingExperience;
    }

    public int getFletchingLevel() {
        return fletchingLevel;
    }

    public int getFishingRank() {
        return fishingRank;
    }

    public int getFishingExperience() {
        return fishingExperience;
    }

    public int getFishingLevel() {
        return fishingLevel;
    }

    public int getFiremakingRank() {
        return firemakingRank;
    }

    public int getFiremakingExperience() {
        return firemakingExperience;
    }

    public int getFiremakingLevel() {
        return firemakingLevel;
    }

    public int getCraftingRank() {
        return craftingRank;
    }

    public int getCraftingExperience() {
        return craftingExperience;
    }

    public int getCraftingLevel() {
        return craftingLevel;
    }

    public int getSmithingRank() {
        return smithingRank;
    }

    public int getSmithingExperience() {
        return smithingExperience;
    }

    public int getSmithingLevel() {
        return smithingLevel;
    }

    public int getMiningRank() {
        return miningRank;
    }

    public int getMiningExperience() {
        return miningExperience;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public int getHerbloreRank() {
        return herbloreRank;
    }

    public int getHerbloreExperience() {
        return herbloreExperience;
    }

    public int getHerbloreLevel() {
        return herbloreLevel;
    }

    public int getAgilityRank() {
        return agilityRank;
    }

    public int getAgilityExperience() {
        return agilityExperience;
    }

    public int getAgilityLevel() {
        return agilityLevel;
    }

    public int getThievingRank() {
        return thievingRank;
    }

    public int getThievingExperience() {
        return thievingExperience;
    }

    public int getThievingLevel() {
        return thievingLevel;
    }

    public int getSlayerRank() {
        return slayerRank;
    }

    public int getSlayerExperience() {
        return slayerExperience;
    }

    public int getSlayerLevel() {
        return slayerLevel;
    }

    public int getFarmingRank(){
        return farmingRank;
    }

    public int getFarmingExperience(){
        return farmingExperience;
    }

    public int getFarmingLevel(){
        return farmingLevel;
    }

    public int getRunecraftingRank() {
        return runecraftingRank;
    }

    public int getRunecraftingExperience() {
        return runecraftingExperience;
    }

    public int getRunecraftingLevel() {
        return runecraftingLevel;
    }

    public int getHunterRank() {
        return hunterRank;
    }

    public int getHunterExperience() {
        return hunterExperience;
    }

    public int getHunterLevel() {
        return hunterLevel;
    }

    public int getConstructionRank() {
        return constructionRank;
    }

    public int getConstructionExperience() {
        return constructionExperience;
    }

    public int getConstructionLevel() {
        return constructionLevel;
    }

    public Timestamp getDataTimeStamp() {
        return dataTimeStamp;
    }
}
