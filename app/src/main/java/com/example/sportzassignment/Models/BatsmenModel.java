package com.example.sportzassignment.Models;

public class BatsmenModel {
    String Batsman,Runs,Balls,Fours,Sixes,Dots,Strikerate,Dismissal,Howout,Bowler,Fielder="";

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

    public String getFours() {
        return Fours;
    }

    public void setFours(String fours) {
        Fours = fours;
    }

    public String getSixes() {
        return Sixes;
    }

    public void setSixes(String sixes) {
        Sixes = sixes;
    }

    public String getDots() {
        return Dots;
    }

    public void setDots(String dots) {
        Dots = dots;
    }

    public String getStrikerate() {
        return Strikerate;
    }

    public void setStrikerate(String strikerate) {
        Strikerate = strikerate;
    }

    public String getDismissal() {
        return Dismissal;
    }

    public void setDismissal(String dismissal) {
        Dismissal = dismissal;
    }

    public String getHowout() {
        return Howout;
    }

    public void setHowout(String howout) {
        Howout = howout;
    }

    public String getBowler() {
        return Bowler;
    }

    public void setBowler(String bowler) {
        Bowler = bowler;
    }

    public String getFielder() {
        return Fielder;
    }

    public void setFielder(String fielder) {
        Fielder = fielder;
    }

    public BatsmenModel() {
    }

    public BatsmenModel(String batsman, String runs, String balls, String fours, String sixes, String dots, String strikerate, String dismissal, String howout, String bowler, String fielder) {
        Batsman = batsman;
        Runs = runs;
        Balls = balls;
        Fours = fours;
        Sixes = sixes;
        Dots = dots;
        Strikerate = strikerate;
        Dismissal = dismissal;
        Howout = howout;
        Bowler = bowler;
        Fielder = fielder;
    }
}
