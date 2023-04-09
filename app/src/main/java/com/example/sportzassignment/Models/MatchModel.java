package com.example.sportzassignment.Models;

public class MatchModel {
    String Livecoverage,Id,Code,League,Number,Type,Date,Time,Offset,Daynight = "";

    public String getLivecoverage() {
        return Livecoverage;
    }

    public void setLivecoverage(String livecoverage) {
        Livecoverage = livecoverage;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getOffset() {
        return Offset;
    }

    public void setOffset(String offset) {
        Offset = offset;
    }

    public String getDaynight() {
        return Daynight;
    }

    public void setDaynight(String daynight) {
        Daynight = daynight;
    }

    public MatchModel() {
    }

    public MatchModel(String livecoverage, String id, String code, String league, String number, String type, String date, String time, String offset, String daynight) {
        Livecoverage = livecoverage;
        Id = id;
        Code = code;
        League = league;
        Number = number;
        Type = type;
        Date = date;
        Time = time;
        Offset = offset;
        Daynight = daynight;
    }
}
