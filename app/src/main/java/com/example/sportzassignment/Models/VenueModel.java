package com.example.sportzassignment.Models;

public class VenueModel {

    String Id,Name="";

    public VenueModel() {
    }

    public VenueModel(String id, String name) {
        Id = id;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
