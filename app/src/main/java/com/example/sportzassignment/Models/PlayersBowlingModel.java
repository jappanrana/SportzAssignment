package com.example.sportzassignment.Models;

public class PlayersBowlingModel {
    String Style,Average,Economyrate,Wickets="";

    public PlayersBowlingModel() {
    }

    public PlayersBowlingModel(String style, String average, String economyrate, String wickets) {
        Style = style;
        Average = average;
        Economyrate = economyrate;
        Wickets = wickets;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }

    public String getAverage() {
        return Average;
    }

    public void setAverage(String average) {
        Average = average;
    }

    public String getEconomyrate() {
        return Economyrate;
    }

    public void setEconomyrate(String economyrate) {
        Economyrate = economyrate;
    }

    public String getWickets() {
        return Wickets;
    }

    public void setWickets(String wickets) {
        Wickets = wickets;
    }
}
