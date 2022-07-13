package com.example.cardiacrecorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.cardiacrecorder.adapter.RecordAdapter;
import com.google.android.material.snackbar.Snackbar;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView;
RecordAdapter recordAdapter;
LinearLayoutManager linearLayoutManager;
Record record;

ArrayList<Record> recordsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordsArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.rvRecords);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recordAdapter = new RecordAdapter(this,R.color.good,R.color.normal,R.color.critical,recordsArrayList);

        recyclerView.setAdapter(recordAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        record = new Record("11-12-21","11:21",126,121,34);
        recordsArrayList.add(record);
        recordsArrayList
                .add(new Record("01-01-01","11:21",126,121,34));
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


}