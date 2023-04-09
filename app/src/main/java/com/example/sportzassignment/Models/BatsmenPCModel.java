package com.example.sportzassignment.Models;

public class BatsmenPCModel {
    String Batsman,Runs,Balls="";

    public String getBatsman() {
        return Batsman;
    }

    public void setBatsman(String batsman) {
        Batsman = batsman;
    }

    public String getRuns() {
        return Runs;
    }

    public void setRuns(String runs) {
        Runs = runs;
    }

    public String getBalls() {
        return Balls;
    }

    public void setBalls(String balls) {
        Balls = balls;
    }

    public BatsmenPCModel() {
    }

    public BatsmenPCModel(String batsman, String runs, String balls) {
        Batsman = batsman;
        Runs = runs;
        Balls = balls;
    }
}
