package com.example.sportzassignment.Models;

public class BowlersModel {

    String Bowler,Overs,Maidens,Runs,Wickets,Economyrate,Noballs,Wides,Dots="";

    public String getBowler() {
        return Bowler;
    }

    public void setBowler(String bowler) {
        Bowler = bowler;
    }

    public String getOvers() {
        return Overs;
    }

    public void setOvers(String overs) {
        Overs = overs;
    }

    public String getMaidens() {
        return Maidens;
    }

    public void setMaidens(String maidens) {
        Maidens = maidens;
    }

    public String getRuns() {
        return Runs;
    }

    public void setRuns(String runs) {
        Runs = runs;
    }

    public String getWickets() {
        return Wickets;
    }

    public void setWickets(String wickets) {
        Wickets = wickets;
    }

    public String getEconomyrate() {
        return Economyrate;
    }

    public void setEconomyrate(String economyrate) {
        Economyrate = economyrate;
    }

    public String getNoballs() {
        return Noballs;
    }

    public void setNoballs(String noballs) {
        Noballs = noballs;
    }

    public String getWides() {
        return Wides;
    }

    public void setWides(String wides) {
        Wides = wides;
    }

    public String getDots() {
        return Dots;
    }

    public void setDots(String dots) {
        Dots = dots;
    }

    public BowlersModel() {
    }

    public BowlersModel(String bowler, String overs, String maidens, String runs, String wickets, String economyrate, String noballs, String wides, String dots) {
        Bowler = bowler;
        Overs = overs;
        Maidens = maidens;
        Runs = runs;
        Wickets = wickets;
        Economyrate = economyrate;
        Noballs = noballs;
        Wides = wides;
        Dots = dots;
    }
}
