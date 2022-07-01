package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent intent = getIntent();
        Record record = intent.getParcelableExtra("record");

        TextView date = findViewById(R.id.DateValue);
        TextView time = findViewById(R.id.TimeValue);
        TextView systolic = findViewById(R.id.SystolicValue);
        TextView diastolic = findViewById(R.id.DiastolicValue);
        TextView heartRate = findViewById(R.id.HeartRateValue);
        TextView comment = findViewById(R.id.CommentValue);
        date.setText(record.getDate());
        time.setText(record.getTime());
        systolic.setText(record.getSystolic());
        diastolic.setText(record.getDiastolic());
        heartRate.setText(record.getHeart_rate());
        comment.setText(record.getComment());
    }
}