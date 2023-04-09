package com.example.sportzassignment.Models;

public class PlayersBattingModel {
    String Style,Average,Strikerate,Runs = "";

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

    public String getStrikerate() {
        return Strikerate;
    }

    public void setStrikerate(String strikerate) {
        Strikerate = strikerate;
    }

    public String getRuns() {
        return Runs;
    }

    public void setRuns(String runs) {
        Runs = runs;
    }

    public PlayersBattingModel() {
    }

    public PlayersBattingModel(String style, String average, String strikerate, String runs) {
        Style = style;
        Average = average;
        Strikerate = strikerate;
        Runs = runs;
    }
}
