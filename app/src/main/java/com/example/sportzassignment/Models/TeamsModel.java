package com.example.sportzassignment.Models;

import java.util.ArrayList;

public class TeamsModel {
    String Key,Name_Full, Name_Short="";

    ArrayList<TeamsPlayersModel> Players;

    public String getName_Full() {
        return Name_Full;
    }

    public void setName_Full(String name_Full) {
        Name_Full = name_Full;
    }

    public String getName_Short() {
        return Name_Short;
    }

    public void setName_Short(String name_Short) {
        Name_Short = name_Short;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public ArrayList<TeamsPlayersModel> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<TeamsPlayersModel> players) {
        Players = players;
    }

    public TeamsModel() {
    }

    public TeamsModel(String key, String name_Full, String name_Short, ArrayList<TeamsPlayersModel> players) {
        Key = key;
        Name_Full = name_Full;
        Name_Short = name_Short;
        Players = players;
    }
}
