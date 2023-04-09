package com.example.sportzassignment.Models;

public class PowerPlayModel {
    String PP1,PP2;

    public String getPP1() {
        return PP1;
    }

    public void setPP1(String PP1) {
        this.PP1 = PP1;
    }

    public String getPP2() {
        return PP2;
    }

    public void setPP2(String PP2) {
        this.PP2 = PP2;
    }

    public PowerPlayModel() {
    }

    public PowerPlayModel(String PP1, String PP2) {
        this.PP1 = PP1;
        this.PP2 = PP2;
    }
}
