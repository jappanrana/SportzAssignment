package com.example.sportzassignment.Models;

public class SeriesModel {
    String Id,Name,Status,Tour,Tour_Name="";

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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTour() {
        return Tour;
    }

    public void setTour(String tour) {
        Tour = tour;
    }

    public String getTour_Name() {
        return Tour_Name;
    }

    public void setTour_Name(String tour_Name) {
        Tour_Name = tour_Name;
    }

    public SeriesModel() {
    }

    public SeriesModel(String id, String name, String status, String tour, String tour_Name) {
        Id = id;
        Name = name;
        Status = status;
        Tour = tour;
        Tour_Name = tour_Name;
    }
}
