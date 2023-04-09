package com.example.sportzassignment.Activities;

import static com.example.sportzassignment.Utils.SharedPrefMethods.sharedTeamsModel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.sportzassignment.Adapters.playersAdapter;
import com.example.sportzassignment.Models.PlayersBattingModel;
import com.example.sportzassignment.Models.PlayersBowlingModel;
import com.example.sportzassignment.Models.TeamsModel;
import com.example.sportzassignment.Models.TeamsPlayersModel;
import com.example.sportzassignment.R;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    Context mContext;
    ImageView detailsScreenBack,detailsScreenFilter;
    RecyclerView detailsScreenRecyclerView;
    ArrayList<TeamsPlayersModel> adapterList;
    playersAdapter adapter;
    playersAdapter.listner listner;
    ArrayList<TeamsModel> savedTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mContext = DetailsActivity.this;

        defineVariables();

        setOnClicks();

    }

    private void defineVariables() {
        detailsScreenBack = findViewById(R.id.detailsScreenBack);
        detailsScreenFilter = findViewById(R.id.detailsScreenFilter);
        detailsScreenRecyclerView = findViewById(R.id.detailsScreenRecyclerView);
        detailsScreenRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        detailsScreenRecyclerView.setItemViewCacheSize(90);
        adapterList = new ArrayList<>();
        savedTeams = sharedTeamsModel(mContext);
        adapterList.addAll(savedTeams.get(0).getPlayers());
        adapterList.addAll(savedTeams.get(1).getPlayers());
        listner = new playersAdapter.listner() {
            @Override
            public void onPlayerTap(PlayersBattingModel batting, PlayersBowlingModel bowling) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Player Info");
                View view = getLayoutInflater().inflate(R.layout.player_info_alert_dialog, null);
                TextView playerAlertBattingValue = view.findViewById(R.id.playerAlertBattingValue);
                TextView playerAlertBowlingValue = view.findViewById(R.id.playerAlertBowlingValue);
                playerAlertBattingValue.setText(batting.getStyle());
                playerAlertBowlingValue.setText(bowling.getStyle());
                builder.setView(view);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };
        adapter = new playersAdapter(adapterList,mContext,listner);
        detailsScreenRecyclerView.setAdapter(adapter);
    }


    private void setOnClicks() {
        detailsScreenBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        detailsScreenFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, detailsScreenFilter);
                popupMenu.getMenuInflater().inflate(R.menu.filter, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Apply the selected filter to the ImageView
                        switch (item.getItemId()) {
                            case R.id.filterAll:
                                adapterList = new ArrayList<>();
                                adapterList.addAll(savedTeams.get(0).getPlayers());
                                adapterList.addAll(savedTeams.get(1).getPlayers());
                                adapter.updateList(adapterList);
                                return true;
                            case R.id.filterTeam1:
                                adapterList = new ArrayList<>();
                                adapterList.addAll(savedTeams.get(0).getPlayers());
                                adapter.updateList(adapterList);
                                return true;
                            case R.id.filterTeam2:
                                adapterList = new ArrayList<>();
                                adapterList.addAll(savedTeams.get(1).getPlayers());
                                adapter.updateList(adapterList);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });


    }
}