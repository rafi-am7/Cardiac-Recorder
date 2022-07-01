package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cardiacrecorder.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*

        //This part is just demo code for adding record, updating and deleting

        private List<Record> records = new ArrayList<>();

        //Adding record without a method
        Intent intent = getIntent();
        Record record = intent.getParcelableExtra("New Record");
        records.add(record);

        //updating a record
        Record r1 = new Record("a","b",2,3,4,"dummy"); // assume that its an old record and needs to be modified
        Intent i1 = new Intent(MainActivity.this,UpdateActivity.class);
        i1.putExtra("Old record",r1);

        Button b;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i1);
            }
        });

        //view record after clicking on a record from the adapter/card view
        Record r2 = new Record("a","b",2,3,4,"dummy"); // assume that its an old record and needs to be modified
        Intent i2 = new Intent(MainActivity.this,UpdateActivity.class);
        i1.putExtra("record",r2);

        */


    }


}