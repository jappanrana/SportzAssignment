package com.example.sportzassignment.Models;

public class OfficialsModel {
    String Umpires,Referee="";

    public String getUmpires() {
        return Umpires;
    }

    public void setUmpires(String umpires) {
        Umpires = umpires;
    }

    public String getReferee() {
        return Referee;
    }

    public void setReferee(String referee) {
        Referee = referee;
    }

    public OfficialsModel() {
    }

    public OfficialsModel(String umpires, String referee) {
        Umpires = umpires;
        Referee = referee;
    }
}
