package com.example.sportzassignment.Models;

import java.util.ArrayList;

public class NotesModel {
    String Key="";
    ArrayList<String> notes;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    public NotesModel() {
    }

    public NotesModel(String key, ArrayList<String> notes) {
        Key = key;
        this.notes = notes;
    }
}
