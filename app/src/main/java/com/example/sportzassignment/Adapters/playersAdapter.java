package com.example.sportzassignment.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportzassignment.Models.PlayersBattingModel;
import com.example.sportzassignment.Models.PlayersBowlingModel;
import com.example.sportzassignment.Models.TeamsPlayersModel;
import com.example.sportzassignment.R;

import java.util.ArrayList;

public class playersAdapter extends RecyclerView.Adapter<playersAdapter.ViewHolder>{

    ArrayList<TeamsPlayersModel> list = new ArrayList<>();
    Context mContext;
    playersAdapter.listner listner;

    public playersAdapter(ArrayList<TeamsPlayersModel> list, Context mContext, playersAdapter.listner listner) {
        this.list = list;
        this.mContext = mContext;
        this.listner = listner;
    }

    @NonNull
    @Override
    public playersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_view_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull playersAdapter.ViewHolder holder, int position) {
        holder.playersName.setText(list.get(position).getName_Full());
        holder.playersPosition.setText(list.get(position).getPosition());
        if(list.get(position).getIscaptain()){
            holder.playersCaptain.setVisibility(View.VISIBLE);
        }else{
            holder.playersCaptain.setVisibility(View.GONE);
        }
        if(list.get(position).getIskeeper()){
            holder.playersWK.setVisibility(View.VISIBLE);
        }else{
            holder.playersWK.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onPlayerTap(list.get(position).getBatting(),list.get(position).getBowling());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView playersName,playersPosition,playersCaptain,playersWK;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playersName = itemView.findViewById(R.id.playersName);
            playersPosition = itemView.findViewById(R.id.playersPosition);
            playersCaptain = itemView.findViewById(R.id.playersCaptain);
            playersWK = itemView.findViewById(R.id.playersWK);
        }
    }

    public void updateList(ArrayList<TeamsPlayersModel> newlist){
        list = newlist;
        notifyDataSetChanged();
    }

    public interface listner{
        void onPlayerTap(PlayersBattingModel batting, PlayersBowlingModel bowling);
    }
}
