package com.example.sportzassignment.Models;

import java.util.ArrayList;

public class PartnershipCurrentModel {
    String Runs,Balls="";
    ArrayList<BatsmenPCModel> Batsmen;

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

    public ArrayList<BatsmenPCModel> getBatsmen() {
        return Batsmen;
    }

    public void setBatsmen(ArrayList<BatsmenPCModel> batsmen) {
        Batsmen = batsmen;
    }

    public PartnershipCurrentModel() {
    }

    public PartnershipCurrentModel(String runs, String balls, ArrayList<BatsmenPCModel> batsmen) {
        Runs = runs;
        Balls = balls;
        Batsmen = batsmen;
    }
}
