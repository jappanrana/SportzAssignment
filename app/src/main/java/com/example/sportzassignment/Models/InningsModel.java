package com.example.sportzassignment.Models;

import java.util.ArrayList;

public class InningsModel {
    String Number,Battingteam,Total,Wickets,Overs,Runrate,Byes,Legbyes,Wides,Noballs,Penalty,AllottedOvers="";
    ArrayList<BatsmenModel> Batsmen;
    PartnershipCurrentModel Partnership_Current;
    ArrayList<BowlersModel> Bowlers;
    ArrayList<FallofWicketsModel> FallofWickets;
    PowerPlayModel PowerPlay;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getBattingteam() {
        return Battingteam;
    }

    public void setBattingteam(String battingteam) {
        Battingteam = battingteam;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getWickets() {
        return Wickets;
    }

    public void setWickets(String wickets) {
        Wickets = wickets;
    }

    public String getOvers() {
        return Overs;
    }

    public void setOvers(String overs) {
        Overs = overs;
    }

    public String getRunrate() {
        return Runrate;
    }

    public void setRunrate(String runrate) {
        Runrate = runrate;
    }

    public String getByes() {
        return Byes;
    }

    public void setByes(String byes) {
        Byes = byes;
    }

    public String getLegbyes() {
        return Legbyes;
    }

    public void setLegbyes(String legbyes) {
        Legbyes = legbyes;
    }

    public String getWides() {
        return Wides;
    }

    public void setWides(String wides) {
        Wides = wides;
    }

    public String getNoballs() {
        return Noballs;
    }

    public void setNoballs(String noballs) {
        Noballs = noballs;
    }

    public String getPenalty() {
        return Penalty;
    }

    public void setPenalty(String penalty) {
        Penalty = penalty;
    }

    public String getAllottedOvers() {
        return AllottedOvers;
    }

    public void setAllottedOvers(String allottedOvers) {
        AllottedOvers = allottedOvers;
    }

    public ArrayList<BatsmenModel> getBatsmen() {
        return Batsmen;
    }

    public void setBatsmen(ArrayList<BatsmenModel> batsmen) {
        Batsmen = batsmen;
    }

    public PartnershipCurrentModel getPartnership_Current() {
        return Partnership_Current;
    }

    public void setPartnership_Current(PartnershipCurrentModel partnership_Current) {
        Partnership_Current = partnership_Current;
    }

    public ArrayList<BowlersModel> getBowlers() {
        return Bowlers;
    }

    public void setBowlers(ArrayList<BowlersModel> bowlers) {
        Bowlers = bowlers;
    }

    public ArrayList<FallofWicketsModel> getFallofWickets() {
        return FallofWickets;
    }

    public void setFallofWickets(ArrayList<FallofWicketsModel> fallofWickets) {
        FallofWickets = fallofWickets;
    }

    public PowerPlayModel getPowerPlay() {
        return PowerPlay;
    }

    public void setPowerPlay(PowerPlayModel powerPlay) {
        PowerPlay = powerPlay;
    }

    public InningsModel() {
    }

    public InningsModel(String number, String battingteam, String total, String wickets, String overs, String runrate, String byes, String legbyes, String wides, String noballs, String penalty, String allottedOvers, ArrayList<BatsmenModel> batsmen, PartnershipCurrentModel partnership_Current, ArrayList<BowlersModel> bowlers, ArrayList<FallofWicketsModel> fallofWickets, PowerPlayModel powerPlay) {
        Number = number;
        Battingteam = battingteam;
        Total = total;
        Wickets = wickets;
        Overs = overs;
        Runrate = runrate;
        Byes = byes;
        Legbyes = legbyes;
        Wides = wides;
        Noballs = noballs;
        Penalty = penalty;
        AllottedOvers = allottedOvers;
        Batsmen = batsmen;
        Partnership_Current = partnership_Current;
        Bowlers = bowlers;
        FallofWickets = fallofWickets;
        PowerPlay = powerPlay;
    }
}
