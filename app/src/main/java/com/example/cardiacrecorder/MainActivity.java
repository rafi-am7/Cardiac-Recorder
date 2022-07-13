package com.example.cardiacrecorder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.cardiacrecorder.adapter.RecordAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView;
RecordAdapter recordAdapter;
LinearLayoutManager linearLayoutManager;
Record record;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
Gson gson;
ArrayList<Record> recordsArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // recordsArrayList = new ArrayList<>();
        retrieveData();
        recyclerView = findViewById(R.id.rvRecords);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recordAdapter = new RecordAdapter(this,R.color.good,R.color.normal,R.color.critical,recordsArrayList);

        recyclerView.setAdapter(recordAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

/*        record = new Record("11-12-21","11:21",126,121,34);
        recordsArrayList.add(record);
        recordsArrayList
                .add(new Record("01-01-01","11:21",126,121,34));
        saveData();
        recordsArrayList
                .add(new Record("01-01-01","11:21",126,121,34));*/



        recordAdapter.notifyDataSetChanged();









        //String date, String time, int systolic, int diastolic, int heart_rate, String comment



/*
                                    dailyBookingDT = i.getValue(DailyBookingDT.class);
                                    roomListArray.add(dailyBookingDT);
                                    mRoomRvAdapter.notifyDataSetChanged();
        ArrayList<String> list = new ArrayList<String>();
        list.add("foo");
        list.add("baar");
        JSONArray jsArray = new JSONArray(list);

        JSONObject obj = ...
        String jsonString = obj.toString(4);

        ArrayList<String> listdata = new ArrayList<String>();
        JSONArray jArray = (JSONArray)jsonObject;
        if (jArray != null) {
            for (int i=0;i<jArray.length();i++){
                listdata.add(jArray.getString(i));
            }
        }*/
        // recordAdapter = new RecordAdapter(this, ContextCompat.getColor(this,R.color.good),ContextCompat.getColor(this,R.color.normal),ContextCompat.getColor(this,R.color.critical),recordList);
    }
    private void saveData()
    {
        sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        String jsonString = gson.toJson(recordsArrayList);
        editor.putString("record",jsonString);
        editor.apply();
    }
    private void retrieveData()
    {
        sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        gson = new Gson();
        String jsonString = sharedPreferences.getString("record",null);
        Type type = new TypeToken<ArrayList<Record>>(){}.getType();
        recordsArrayList = gson.fromJson(jsonString,type);
        if(recordsArrayList ==null)
        {
            recordsArrayList = new ArrayList<Record>();
        }

    }


}