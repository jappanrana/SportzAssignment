package com.example.sportzassignment.Activities;

import static com.example.sportzassignment.Utils.AsyncHttpRequest.sendRequestAsync;
import static com.example.sportzassignment.Utils.CommonMethods.isNetworkAvailable;
import static com.example.sportzassignment.Utils.SharedPrefMethods.sharedInnings;
import static com.example.sportzassignment.Utils.SharedPrefMethods.sharedMatchdetailModel;
import static com.example.sportzassignment.Utils.SharedPrefMethods.sharedNotesModel;
import static com.example.sportzassignment.Utils.SharedPrefMethods.sharedNuggets;
import static com.example.sportzassignment.Utils.SharedPrefMethods.sharedTeamsModel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.sportzassignment.Models.BatsmenModel;
import com.example.sportzassignment.Models.BatsmenPCModel;
import com.example.sportzassignment.Models.BowlersModel;
import com.example.sportzassignment.Models.FallofWicketsModel;
import com.example.sportzassignment.Models.InningsModel;
import com.example.sportzassignment.Models.MatchModel;
import com.example.sportzassignment.Models.MatchdetailModel;
import com.example.sportzassignment.Models.NotesModel;
import com.example.sportzassignment.Models.OfficialsModel;
import com.example.sportzassignment.Models.PartnershipCurrentModel;
import com.example.sportzassignment.Models.PlayersBattingModel;
import com.example.sportzassignment.Models.PlayersBowlingModel;
import com.example.sportzassignment.Models.PowerPlayModel;
import com.example.sportzassignment.Models.SeriesModel;
import com.example.sportzassignment.Models.TeamsModel;
import com.example.sportzassignment.Models.TeamsPlayersModel;
import com.example.sportzassignment.Models.VenueModel;
import com.example.sportzassignment.R;
import com.example.sportzassignment.Utils.AsyncHttpRequest;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    AsyncHttpRequest.HttpRequestListener listner;
    TextView homeScreenHeaderTeam1,homeScreenHeaderTeam2,homeScreenDate,homeScreenTime,homeScreenLeague,homeScreenType,
            homeScreenTeam1Name,homeScreenTeam2Name,homeScreenVenueName,homeScreenMatchNumber,homeScreenStatus,homeScreenTourName;
    ConstraintLayout homeScreenTeamButton;
    MatchdetailModel Matchdetail;
    ArrayList<TeamsModel> Teams;
    ArrayList<NotesModel> Notes;
    ArrayList<String> Nuggets;
    ArrayList<InningsModel> Innings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        defineVariables();

        if(isNetworkAvailable(mContext)){
            apiCall();
        }else{
            Toast.makeText(mContext, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void defineVariables() {
        homeScreenHeaderTeam1 = findViewById(R.id.homeScreenHeaderTeam1);
        homeScreenHeaderTeam2 = findViewById(R.id.homeScreenHeaderTeam2);
        homeScreenDate = findViewById(R.id.homeScreenDate);
        homeScreenTime = findViewById(R.id.homeScreenTime);
        homeScreenTeam1Name = findViewById(R.id.homeScreenTeam1Name);
        homeScreenTeam2Name = findViewById(R.id.homeScreenTeam2Name);
        homeScreenVenueName = findViewById(R.id.homeScreenVenueName);
        homeScreenLeague = findViewById(R.id.homeScreenLeague);
        homeScreenType = findViewById(R.id.homeScreenType);
        homeScreenMatchNumber = findViewById(R.id.homeScreenMatchNumber);
        homeScreenStatus = findViewById(R.id.homeScreenStatus);
        homeScreenTourName = findViewById(R.id.homeScreenTourName);
        homeScreenTeamButton = findViewById(R.id.homeScreenTeamButton);

        homeScreenTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DetailsActivity.class));
            }
        });

        Matchdetail = new MatchdetailModel();
        Innings = new ArrayList<>();
        Nuggets = new ArrayList<>();
        Teams = new ArrayList<>();
        Notes = new ArrayList<>();
    }

    private void apiCall() {
        listner = new AsyncHttpRequest.HttpRequestListener() {
            @Override
            public void onSuccess(String response) {
                try{
                    JSONObject responseJson = new JSONObject(response);
                    if(responseJson.has("Matchdetail")){
                        JSONObject responseMatchdetail = responseJson.getJSONObject("Matchdetail");
                        if(responseMatchdetail.has("Team_Home")){
                            Matchdetail.setTeam_Home(responseMatchdetail.getString("Team_Home"));
                        }
                        if(responseMatchdetail.has("Team_Away")){
                            Matchdetail.setTeam_Away(responseMatchdetail.getString("Team_Away"));
                        }
                        if(responseMatchdetail.has("Match")){
                            JSONObject responseMatchdetailMatch = responseMatchdetail.getJSONObject("Match");
                            MatchModel temp = new MatchModel();
                            if(responseMatchdetailMatch.has("Livecoverage")){
                                temp.setLivecoverage(responseMatchdetailMatch.getString("Livecoverage"));
                            }
                            if(responseMatchdetailMatch.has("Id")){
                                temp.setId(responseMatchdetailMatch.getString("Id"));
                            }
                            if(responseMatchdetailMatch.has("Code")){
                                temp.setCode(responseMatchdetailMatch.getString("Code"));
                            }
                            if(responseMatchdetailMatch.has("League")){
                                temp.setLeague(responseMatchdetailMatch.getString("League"));
                            }
                            if(responseMatchdetailMatch.has("Number")){
                                temp.setNumber(responseMatchdetailMatch.getString("Number"));
                            }
                            if(responseMatchdetailMatch.has("Type")){
                                temp.setType(responseMatchdetailMatch.getString("Type"));
                            }
                            if(responseMatchdetailMatch.has("Date")){
                                temp.setDate(responseMatchdetailMatch.getString("Date"));
                            }
                            if(responseMatchdetailMatch.has("Time")){
                                temp.setTime(responseMatchdetailMatch.getString("Time"));
                            }
                            if(responseMatchdetailMatch.has("Offset")){
                                temp.setOffset(responseMatchdetailMatch.getString("Offset"));
                            }
                            if(responseMatchdetailMatch.has("Daynight")){
                                temp.setDaynight(responseMatchdetailMatch.getString("Daynight"));
                            }
                            Matchdetail.setMatch(temp);
                        }
                        if(responseMatchdetail.has("Series")){
                            JSONObject responseMatchdetailSeries = responseMatchdetail.getJSONObject("Series");
                            SeriesModel temp = new SeriesModel();
                            if(responseMatchdetailSeries.has("Id")){
                                temp.setId(responseMatchdetailSeries.getString("Id"));
                            }
                            if(responseMatchdetailSeries.has("Name")){
                                temp.setName(responseMatchdetailSeries.getString("Name"));
                            }
                            if(responseMatchdetailSeries.has("Status")){
                                temp.setStatus(responseMatchdetailSeries.getString("Status"));
                            }
                            if(responseMatchdetailSeries.has("Tour")){
                                temp.setTour(responseMatchdetailSeries.getString("Tour"));
                            }
                            if(responseMatchdetailSeries.has("Tour_Name")){
                                temp.setTour_Name(responseMatchdetailSeries.getString("Tour_Name"));
                            }
                            Matchdetail.setSeries(temp);
                        }
                        if(responseMatchdetail.has("Venue")){
                            JSONObject responseMatchdetailVenue = responseMatchdetail.getJSONObject("Venue");
                            VenueModel temp = new VenueModel();
                            if(responseMatchdetailVenue.has("Id")){
                                temp.setId(responseMatchdetailVenue.getString("Id"));
                            }
                            if(responseMatchdetailVenue.has("Name")){
                                temp.setName(responseMatchdetailVenue.getString("Name"));
                            }
                            Matchdetail.setVenue(temp);
                        }
                        if(responseMatchdetail.has("Officials")){
                            JSONObject responseMatchdetailOfficials = responseMatchdetail.getJSONObject("Officials");
                            OfficialsModel temp = new OfficialsModel();
                            if(responseMatchdetailOfficials.has("Umpires")){
                                temp.setUmpires(responseMatchdetailOfficials.getString("Umpires"));
                            }
                            if(responseMatchdetailOfficials.has("Referee")){
                                temp.setReferee(responseMatchdetailOfficials.getString("Referee"));
                            }
                            Matchdetail.setOfficials(temp);
                        }
                        if(responseMatchdetail.has("Weather")){
                            Matchdetail.setWeather(responseMatchdetail.getString("Weather"));
                        }
                        if(responseMatchdetail.has("Weather")){
                            Matchdetail.setWeather(responseMatchdetail.getString("Weather"));
                        }
                        if(responseMatchdetail.has("Tosswonby")){
                            Matchdetail.setTosswonby(responseMatchdetail.getString("Tosswonby"));
                        }
                        if(responseMatchdetail.has("Status")){
                            Matchdetail.setStatus(responseMatchdetail.getString("Status"));
                        }
                        if(responseMatchdetail.has("Status_Id")){
                            Matchdetail.setStatus_Id(responseMatchdetail.getString("Status_Id"));
                        }
                        if(responseMatchdetail.has("Player_Match")){
                            Matchdetail.setPlayer_Match(responseMatchdetail.getString("Player_Match"));
                        }
                        if(responseMatchdetail.has("Result")){
                            Matchdetail.setResult(responseMatchdetail.getString("Result"));
                        }
                        if(responseMatchdetail.has("Winningteam")){
                            Matchdetail.setWinningteam(responseMatchdetail.getString("Winningteam"));
                        }
                        if(responseMatchdetail.has("Winmargin")){
                            Matchdetail.setWinmargin(responseMatchdetail.getString("Winmargin"));
                        }
                        if(responseMatchdetail.has("Equation")){
                            Matchdetail.setEquation(responseMatchdetail.getString("Equation"));
                        }
                    }
                    if(responseJson.has("Nuggets")){
                        JSONArray responseNuggets = responseJson.getJSONArray("Nuggets");
                        int i = 0;
                        while(i<responseNuggets.length()){
                            String stringItem = responseNuggets.getString(i);
                            Nuggets.add(stringItem);
                            i++;
                        }
                    }
                    if(responseJson.has("Innings")){
                        JSONArray responeInnings = responseJson.getJSONArray("Innings");
                        int i = 0;
                        while(i<responeInnings.length()){
                            InningsModel temp = new InningsModel();
                            JSONObject inningsItem = responeInnings.getJSONObject(i);
                            if(inningsItem.has("Number")){
                                temp.setNumber(inningsItem.getString("Number"));
                            }
                            if(inningsItem.has("Battingteam")){
                                temp.setBattingteam(inningsItem.getString("Battingteam"));
                            }
                            if(inningsItem.has("Total")){
                                temp.setTotal(inningsItem.getString("Total"));
                            }
                            if(inningsItem.has("Wickets")){
                                temp.setWickets(inningsItem.getString("Wickets"));
                            }
                            if(inningsItem.has("Overs")){
                                temp.setOvers(inningsItem.getString("Overs"));
                            }
                            if(inningsItem.has("Runrate")){
                                temp.setRunrate(inningsItem.getString("Runrate"));
                            }
                            if(inningsItem.has("Byes")){
                                temp.setByes(inningsItem.getString("Byes"));
                            }
                            if(inningsItem.has("Legbyes")){
                                temp.setLegbyes(inningsItem.getString("Legbyes"));
                            }
                            if(inningsItem.has("Wides")){
                                temp.setWides(inningsItem.getString("Wides"));
                            }
                            if(inningsItem.has("Noballs")){
                                temp.setNoballs(inningsItem.getString("Noballs"));
                            }
                            if(inningsItem.has("Penalty")){
                                temp.setPenalty(inningsItem.getString("Penalty"));
                            }
                            if(inningsItem.has("AllottedOvers")){
                                temp.setAllottedOvers(inningsItem.getString("AllottedOvers"));
                            }
                            if(inningsItem.has("Batsmen")){
                                JSONArray responseBatsmen = inningsItem.getJSONArray("Batsmen");
                                ArrayList<BatsmenModel> innBtsArr = new ArrayList<>();
                                int j = 0;
                                while(j<responseBatsmen.length()){
                                    BatsmenModel temp2 = new BatsmenModel();
                                    JSONObject responsetemp = responseBatsmen.getJSONObject(j);
                                    if(responsetemp.has("Batsman")){
                                        temp2.setBatsman(responsetemp.getString("Batsman"));
                                    }
                                    if(responsetemp.has("Batsman")){
                                        temp2.setBatsman(responsetemp.getString("Batsman"));
                                    }
                                    if(responsetemp.has("Runs")){
                                        temp2.setRuns(responsetemp.getString("Runs"));
                                    }
                                    if(responsetemp.has("Balls")){
                                        temp2.setBalls(responsetemp.getString("Balls"));
                                    }
                                    if(responsetemp.has("Fours")){
                                        temp2.setFours(responsetemp.getString("Fours"));
                                    }
                                    if(responsetemp.has("Sixes")){
                                        temp2.setSixes(responsetemp.getString("Sixes"));
                                    }
                                    if(responsetemp.has("Dots")){
                                        temp2.setDots(responsetemp.getString("Dots"));
                                    }
                                    if(responsetemp.has("Strikerate")){
                                        temp2.setStrikerate(responsetemp.getString("Strikerate"));
                                    }
                                    if(responsetemp.has("Dismissal")){
                                        temp2.setDismissal(responsetemp.getString("Dismissal"));
                                    }
                                    if(responsetemp.has("Howout")){
                                        temp2.setHowout(responsetemp.getString("Howout"));
                                    }
                                    if(responsetemp.has("Bowler")){
                                        temp2.setBowler(responsetemp.getString("Bowler"));
                                    }
                                    if(responsetemp.has("Fielder")){
                                        temp2.setFielder(responsetemp.getString("Fielder"));
                                    }
                                    innBtsArr.add(temp2);
                                    j++;
                                }
                                temp.setBatsmen(innBtsArr);
                            }
                            if(inningsItem.has("Partnership_Current")){
                                JSONObject responseTemp = inningsItem.getJSONObject("Partnership_Current");
                                PartnershipCurrentModel temp2 = new PartnershipCurrentModel();
                                if(responseTemp.has("Runs")){
                                    temp2.setRuns(responseTemp.getString("Runs"));
                                }
                                if(responseTemp.has("Balls")){
                                    temp2.setBalls(responseTemp.getString("Balls"));
                                }
                                if(responseTemp.has("Batsmen")){
                                    ArrayList<BatsmenPCModel> temp3 = new ArrayList<>();
                                    JSONArray responsePcBatsmen = responseTemp.getJSONArray("Batsmen");
                                    int j = 0;
                                    while(j<responsePcBatsmen.length()){
                                        JSONObject responsePcBatsItem = responsePcBatsmen.getJSONObject(j);
                                        BatsmenPCModel item = new BatsmenPCModel();
                                        if(responsePcBatsItem.has("Batsman")){
                                            item.setBatsman(responsePcBatsItem.getString("Batsman"));
                                        }
                                        if(responsePcBatsItem.has("Runs")){
                                            item.setRuns(responsePcBatsItem.getString("Runs"));
                                        }
                                        if(responsePcBatsItem.has("Balls")){
                                            item.setBalls(responsePcBatsItem.getString("Balls"));
                                        }
                                        temp3.add(item);
                                        j++;
                                    }
                                    temp2.setBatsmen(temp3);
                                }
                                temp.setPartnership_Current(temp2);
                            }
                            if(inningsItem.has("Bowlers")){
                                ArrayList<BowlersModel> temp2 = new ArrayList<>();
                                JSONArray responeBowlers = inningsItem.getJSONArray("Bowlers");
                                int j = 0;
                                while(j<responeBowlers.length()){
                                    JSONObject resBowler = responeBowlers.getJSONObject(j);
                                    BowlersModel item = new BowlersModel();
                                    if(resBowler.has("Bowler")){
                                        item.setBowler(resBowler.getString("Bowler"));
                                    }
                                    if(resBowler.has("Overs")){
                                        item.setOvers(resBowler.getString("Overs"));
                                    }
                                    if(resBowler.has("Maidens")){
                                        item.setMaidens(resBowler.getString("Maidens"));
                                    }
                                    if(resBowler.has("Runs")){
                                        item.setRuns(resBowler.getString("Runs"));
                                    }
                                    if(resBowler.has("Wickets")){
                                        item.setWickets(resBowler.getString("Wickets"));
                                    }
                                    if(resBowler.has("Economyrate")){
                                        item.setEconomyrate(resBowler.getString("Economyrate"));
                                    }
                                    if(resBowler.has("Noballs")){
                                        item.setNoballs(resBowler.getString("Noballs"));
                                    }
                                    if(resBowler.has("Wides")){
                                        item.setWides(resBowler.getString("Wides"));
                                    }
                                    if(resBowler.has("Dots")){
                                        item.setDots(resBowler.getString("Dots"));
                                    }
                                    temp2.add(item);
                                    j++;
                                }
                                temp.setBowlers(temp2);
                            }
                            if(inningsItem.has("FallofWickets")){
                                 JSONArray resFallWickets = inningsItem.getJSONArray("FallofWickets");
                                 ArrayList<FallofWicketsModel> temp2 = new ArrayList<>();
                                 int j = 0;
                                 while(j<resFallWickets.length()){
                                     FallofWicketsModel item = new FallofWicketsModel();
                                     JSONObject resItem = resFallWickets.getJSONObject(j);
                                     if(resItem.has("Batsman")){
                                         item.setBatsman(resItem.getString("Batsman"));
                                     }
                                     if(resItem.has("Score")){
                                         item.setScore(resItem.getString("Score"));
                                     }
                                     if(resItem.has("Overs")){
                                         item.setOvers(resItem.getString("Overs"));
                                     }
                                     temp2.add(item);
                                     j++;
                                 }
                                 temp.setFallofWickets(temp2);
                            }
                            if(inningsItem.has("PowerPlay")){
                                PowerPlayModel temp2 = new PowerPlayModel();
                                JSONObject responsePP = inningsItem.getJSONObject("PowerPlay");
                                if(responsePP.has("PP1")){
                                    temp2.setPP1(responsePP.getString("PP1"));
                                }
                                if(responsePP.has("PP2")){
                                    temp2.setPP2(responsePP.getString("PP2"));
                                }
                                temp.setPowerPlay(temp2);
                            }
                            Innings.add(temp);
                            i++;
                        }
                    }
                    if(responseJson.has("Teams")){
                        JSONObject responseTeams = responseJson.getJSONObject("Teams");
                        Iterator<String> keys = responseTeams.keys();
                        while(keys.hasNext()){
                            TeamsModel temp = new TeamsModel();
                            String key = keys.next();
                            JSONObject responseTeamsTemp = responseTeams.getJSONObject(key);
                            temp.setKey(key);
                            if(responseTeamsTemp.has("Name_Full")){
                                temp.setName_Full(responseTeamsTemp.getString("Name_Full"));
                            }
                            if(responseTeamsTemp.has("Name_Short")){
                                temp.setName_Short(responseTeamsTemp.getString("Name_Short"));
                            }
                            ArrayList<TeamsPlayersModel> tempList = new ArrayList<>();
                            if(responseTeamsTemp.has("Players")){
                                JSONObject responseTeamsPlayers = responseTeamsTemp.getJSONObject("Players");
                                Iterator<String> playersKeys = responseTeamsPlayers.keys();
                                while(playersKeys.hasNext()){
                                    TeamsPlayersModel temp2 = new TeamsPlayersModel();
                                    String playerKey = playersKeys.next();
                                    JSONObject responseTeamsPlayerTemp = responseTeamsPlayers.getJSONObject(playerKey);
                                    if(responseTeamsPlayerTemp.has("Position")){
                                        temp2.setPosition(responseTeamsPlayerTemp.getString("Position"));
                                    }
                                    if(responseTeamsPlayerTemp.has("Name_Full")){
                                        temp2.setName_Full(responseTeamsPlayerTemp.getString("Name_Full"));
                                    }
                                    if(responseTeamsPlayerTemp.has("Iscaptain")){
                                        temp2.setIscaptain(responseTeamsPlayerTemp.getBoolean("Iscaptain"));
                                    }
                                    if(responseTeamsPlayerTemp.has("Iskeeper")){
                                        temp2.setIskeeper(responseTeamsPlayerTemp.getBoolean("Iskeeper"));
                                    }
                                    if(responseTeamsPlayerTemp.has("Batting")){
                                        PlayersBattingModel tempBatting = new PlayersBattingModel();
                                        JSONObject responseTeamsPlayerTempBatting = responseTeamsPlayerTemp.getJSONObject("Batting");
                                        if(responseTeamsPlayerTempBatting.has("Style")){
                                            tempBatting.setStyle(responseTeamsPlayerTempBatting.getString("Style"));
                                        }
                                        if(responseTeamsPlayerTempBatting.has("Average")){
                                            tempBatting.setAverage(responseTeamsPlayerTempBatting.getString("Average"));
                                        }
                                        if(responseTeamsPlayerTempBatting.has("Strikerate")){
                                            tempBatting.setStrikerate(responseTeamsPlayerTempBatting.getString("Strikerate"));
                                        }
                                        if(responseTeamsPlayerTempBatting.has("Runs")){
                                            tempBatting.setRuns(responseTeamsPlayerTempBatting.getString("Runs"));
                                        }
                                        temp2.setBatting(tempBatting);
                                    }
                                    if(responseTeamsPlayerTemp.has("Bowling")){
                                        PlayersBowlingModel tempBowling = new PlayersBowlingModel();
                                        JSONObject responseTeamsPlayerTempBowling = responseTeamsPlayerTemp.getJSONObject("Bowling");
                                        if(responseTeamsPlayerTempBowling.has("Style")){
                                            tempBowling.setStyle(responseTeamsPlayerTempBowling.getString("Style"));
                                        }
                                        if(responseTeamsPlayerTempBowling.has("Average")){
                                            tempBowling.setAverage(responseTeamsPlayerTempBowling.getString("Average"));
                                        }
                                        if(responseTeamsPlayerTempBowling.has("Economyrate")){
                                            tempBowling.setEconomyrate(responseTeamsPlayerTempBowling.getString("Economyrate"));
                                        }
                                        if(responseTeamsPlayerTempBowling.has("Wickets")){
                                            tempBowling.setWickets(responseTeamsPlayerTempBowling.getString("Wickets"));
                                        }
                                        temp2.setBowling(tempBowling);
                                    }
                                    tempList.add(temp2);
                                }
                            }
                            temp.setPlayers(tempList);
                            Teams.add(temp);
                        }
                    }
                    if(responseJson.has("Notes")){
                        JSONObject responseNotes = responseJson.getJSONObject("Notes");
                        Iterator<String> keys = responseNotes.keys();
                        while (keys.hasNext()){
                            NotesModel temp = new NotesModel();
                            String key = keys.next();
                            temp.setKey(key);
                            JSONArray temp2 = responseNotes.getJSONArray(key);
                            int i = 0;
                            ArrayList<String> tempList = new ArrayList<>();
                            while(i<temp2.length()){
                                String stringItem = temp2.getString(i);
                                tempList.add(stringItem);
                                i++;
                            }
                            temp.setNotes(tempList);
                            Notes.add(temp);
                        }
                    }
                    sharedMatchdetailModel(mContext,Matchdetail);
                    sharedTeamsModel(mContext,Teams);
                    sharedNotesModel(mContext,Notes);
                    sharedNuggets(mContext,Nuggets);
                    sharedInnings(mContext,Innings);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            UiChanges();
                        }
                    });
                }catch (Exception ex){
                    Log.e("asdasdtest1", ex.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mContext, "Desired Data Not Found", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onError(int responseCode, String error) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContext, "Server Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

        sendRequestAsync("GET","https://demo.sportz.io/sapk01222019186652.json",listner);
    }

    private void UiChanges(){
        homeScreenHeaderTeam1.setText(Teams.get(0).getName_Short());
        homeScreenHeaderTeam2.setText(Teams.get(1).getName_Short());
        homeScreenDate.setText(Matchdetail.getMatch().getDate());
        homeScreenTime.setText(Matchdetail.getMatch().getTime());
        homeScreenLeague.setText(Matchdetail.getMatch().getLeague());
        homeScreenType.setText(Matchdetail.getMatch().getType());
        homeScreenTeam1Name.setText(Teams.get(0).getName_Full());
        homeScreenTeam2Name.setText(Teams.get(1).getName_Full());
        homeScreenVenueName.setText(Matchdetail.getVenue().getName());
        homeScreenMatchNumber.setText(Matchdetail.getMatch().getNumber());
        homeScreenTourName.setText(Matchdetail.getSeries().getTour_Name());
        homeScreenStatus.setText(Matchdetail.getStatus());
    }
}