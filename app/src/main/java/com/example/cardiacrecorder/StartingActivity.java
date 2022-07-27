package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class StartingActivity extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        //getSupportActionBar().hide();
        delayGeneration();


    }

    /**
     * method for generating delay
     */
    private void delayGeneration() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = new Intent(StartingActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }

        },3000);
    }


}