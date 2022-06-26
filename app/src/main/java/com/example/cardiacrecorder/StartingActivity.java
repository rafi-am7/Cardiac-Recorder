package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.window.SplashScreen;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cardiacrecorder.databinding.ActivityStartingBinding;

public class StartingActivity extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        getSupportActionBar().hide();
        boolean b = new Handler().postDelayed(new Runnable() {
                                                  @Override
                                                  public void run() {
                                                      i = new Intent(StartingActivity.this, MainActivity.class);
                                                      startActivity(i);
                                                      finish();
                                                  }
                                              });

    }


}