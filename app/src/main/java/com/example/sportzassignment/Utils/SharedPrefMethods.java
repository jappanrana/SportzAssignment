package com.example.sportzassignment.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sportzassignment.Models.InningsModel;
import com.example.sportzassignment.Models.MatchdetailModel;
import com.example.sportzassignment.Models.NotesModel;
import com.example.sportzassignment.Models.TeamsModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharedPrefMethods {

    static Gson gs = new Gson();

    public static void sharedMatchdetailModel(Context context, MatchdetailModel value){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        String strValue = gs.toJson(value);
        sharedPreferenceObject.edit().putString("Matchdetail",strValue).apply();
    }

    public static MatchdetailModel sharedMatchdetailModel(Context context){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        MatchdetailModel value = gs.fromJson(sharedPreferenceObject.getString("Matchdetail",""),MatchdetailModel.class);
        return value;
    }

    public static void sharedTeamsModel(Context context, ArrayList<TeamsModel> value){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        String strValue = gs.toJson(value);
        sharedPreferenceObject.edit().putString("Teams",strValue).apply();
    }

    public static ArrayList<TeamsModel> sharedTeamsModel(Context context){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        Type listType = new TypeToken<ArrayList<TeamsModel>>() {}.getType();
        ArrayList<TeamsModel> value = gs.fromJson(sharedPreferenceObject.getString("Teams",""),listType);
        return value;
    }

    public static void sharedNotesModel(Context context, ArrayList<NotesModel> value){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        String strValue = gs.toJson(value);
        sharedPreferenceObject.edit().putString("Notes",strValue).apply();
    }

    public static ArrayList<NotesModel> sharedNotesModel(Context context){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        Type listType = new TypeToken<ArrayList<NotesModel>>() {}.getType();
        ArrayList<NotesModel> value = gs.fromJson(sharedPreferenceObject.getString("Notes",""),listType);
        return value;
    }

    public static void sharedNuggets(Context context, ArrayList<String> value){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        String strValue = gs.toJson(value);
        sharedPreferenceObject.edit().putString("Nuggets",strValue).apply();
    }

    public static ArrayList<String> sharedNuggets(Context context){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> value = gs.fromJson(sharedPreferenceObject.getString("Nuggets",""),listType);
        return value;
    }
    public static void sharedInnings(Context context, ArrayList<InningsModel> value){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        String strValue = gs.toJson(value);
        sharedPreferenceObject.edit().putString("InningsModel",strValue).apply();
    }

    public static ArrayList<InningsModel> sharedInnings(Context context){
        SharedPreferences sharedPreferenceObject = context.getSharedPreferences("sharedPrefStorage",0);
        Type listType = new TypeToken<ArrayList<InningsModel>>() {}.getType();
        ArrayList<InningsModel> value = gs.fromJson(sharedPreferenceObject.getString("InningsModel",""),listType);
        return value;
    }



}
