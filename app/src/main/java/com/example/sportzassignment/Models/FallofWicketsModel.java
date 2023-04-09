package com.example.sportzassignment.Models;

public class FallofWicketsModel {

    String Batsman,Score,Overs="";

    public String getBatsman() {
        return Batsman;
    }

    public void setBatsman(String batsman) {
        Batsman = batsman;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getOvers() {
        return Overs;
    }

    public void setOvers(String overs) {
        Overs = overs;
    }

    public FallofWicketsModel() {
    }

    public FallofWicketsModel(String batsman, String score, String overs) {
        Batsman = batsman;
        Score = score;
        Overs = overs;
    }
}
