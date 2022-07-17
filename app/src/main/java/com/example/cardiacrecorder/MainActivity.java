package com.example.cardiacrecorder;

import android.bluetooth.BluetoothManager;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardiacrecorder.adapter.RecordAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static RecyclerView recyclerView;
static RecordAdapter recordAdapter;
LinearLayoutManager linearLayoutManager;
Record record;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
Gson gson;
ArrayList<Record> recordsArrayList;
ImageView addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);

       // recordsArrayList = new ArrayList<>();
        retrieveData();
        recyclerView = findViewById(R.id.rvRecords);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recordAdapter = new RecordAdapter(this,R.color.good,R.color.normal,R.color.critical,recordsArrayList);

        recyclerView.setAdapter(recordAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recordAdapter.setCustomClickListener(new RecordAdapter.CustomClickListener() {
            @Override
            public void customOnClick(int position, View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }

            @Override
            public void customOnLongClick(int position, View v) {

            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddActivity.class));
                finish();
            }
        });







/*        record = new Record("11-12-21","11:21",126,121,34);
        recordsArrayList.add(record);
        recordsArrayList
                .add(new Record("01-01-01","11:21",126,121,34));
        saveData();
        recordsArrayList
                .add(new Record("01-01-01","11:21",126,121,34));*/



        //recordAdapter.notifyDataSetChanged();









        //String date, String time, int systolic, int diastolic, int heart_rate, String comment



/*

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