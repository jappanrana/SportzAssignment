package com.example.sportzassignment.Models;

public class TeamsPlayersModel {
    String Key,Name_Full,Position="";
    PlayersBattingModel Batting;
    PlayersBowlingModel Bowling;
    Boolean Iscaptain,Iskeeper = false;

    public TeamsPlayersModel() {
    }

    public String getName_Full() {
        return Name_Full;
    }

    public void setName_Full(String name_Full) {
        Name_Full = name_Full;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public PlayersBattingModel getBatting() {
        return Batting;
    }

    public void setBatting(PlayersBattingModel batting) {
        Batting = batting;
    }

    public PlayersBowlingModel getBowling() {
        return Bowling;
    }

    public void setBowling(PlayersBowlingModel bowling) {
        Bowling = bowling;
    }

    public Boolean getIscaptain() {
        return Iscaptain;
    }

    public void setIscaptain(Boolean iscaptain) {
        Iscaptain = iscaptain;
    }

    public Boolean getIskeeper() {
        return Iskeeper;
    }

    public void setIskeeper(Boolean iskeeper) {
        Iskeeper = iskeeper;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public TeamsPlayersModel(String key, String name_Full, String position, PlayersBattingModel batting, PlayersBowlingModel bowling, Boolean iscaptain, Boolean iskeeper) {
        Key = key;
        Name_Full = name_Full;
        Position = position;
        Batting = batting;
        Bowling = bowling;
        Iscaptain = iscaptain;
        Iskeeper = iskeeper;
    }
}
