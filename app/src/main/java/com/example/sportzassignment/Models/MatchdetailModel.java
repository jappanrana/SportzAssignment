package com.example.sportzassignment.Models;

public class MatchdetailModel {

    String Team_Home,Team_Away="";
    MatchModel Match;
    SeriesModel Series;
    VenueModel Venue;
    OfficialsModel Officials;
    String Weather,Tosswonby,Status,Status_Id,Player_Match,Result,Winningteam,Winmargin,Equation="";

    public MatchdetailModel() {
    }

    public MatchdetailModel(String team_Home, String team_Away, MatchModel match, SeriesModel series, VenueModel venue, OfficialsModel officials, String weather, String tosswonby, String status, String status_Id, String player_Match, String result, String winningteam, String winmargin, String equation) {
        Team_Home = team_Home;
        Team_Away = team_Away;
        Match = match;
        Series = series;
        Venue = venue;
        Officials = officials;
        Weather = weather;
        Tosswonby = tosswonby;
        Status = status;
        Status_Id = status_Id;
        Player_Match = player_Match;
        Result = result;
        Winningteam = winningteam;
        Winmargin = winmargin;
        Equation = equation;
    }

    public String getTeam_Home() {
        return Team_Home;
    }

    public void setTeam_Home(String team_Home) {
        Team_Home = team_Home;
    }

    public String getTeam_Away() {
        return Team_Away;
    }

    public void setTeam_Away(String team_Away) {
        Team_Away = team_Away;
    }

    public MatchModel getMatch() {
        return Match;
    }

    public void setMatch(MatchModel match) {
        Match = match;
    }

    public SeriesModel getSeries() {
        return Series;
    }

    public void setSeries(SeriesModel series) {
        Series = series;
    }

    public VenueModel getVenue() {
        return Venue;
    }

    public void setVenue(VenueModel venue) {
        Venue = venue;
    }

    public OfficialsModel getOfficials() {
        return Officials;
    }

    public void setOfficials(OfficialsModel officials) {
        Officials = officials;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public String getTosswonby() {
        return Tosswonby;
    }

    public void setTosswonby(String tosswonby) {
        Tosswonby = tosswonby;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus_Id() {
        return Status_Id;
    }

    public void setStatus_Id(String status_Id) {
        Status_Id = status_Id;
    }

    public String getPlayer_Match() {
        return Player_Match;
    }

    public void setPlayer_Match(String player_Match) {
        Player_Match = player_Match;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getWinningteam() {
        return Winningteam;
    }

    public void setWinningteam(String winningteam) {
        Winningteam = winningteam;
    }

    public String getWinmargin() {
        return Winmargin;
    }

    public void setWinmargin(String winmargin) {
        Winmargin = winmargin;
    }

    public String getEquation() {
        return Equation;
    }

    public void setEquation(String equation) {
        Equation = equation;
    }
}
