package com.example.cardiacrecorder;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardiacrecorder.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView;
RecordAdapter recordAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvRecords);
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


}