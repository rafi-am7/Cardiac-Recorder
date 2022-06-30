package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    Record record = new Record("30/06/2022","22.30",112,79,70,"Resting");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        TextView date = findViewById(R.id.DateValue);
        TextView time = (TextView) findViewById(R.id.TimeValue);
        TextView systolic = (TextView) findViewById(R.id.SystolicValue);
        TextView diastolic = (TextView) findViewById(R.id.DiastolicValue);
        TextView heartRate = (TextView) findViewById(R.id.HeartRateValue);
        TextView comment = (TextView) findViewById(R.id.CommentValue);
        date.setText(record.getDate());
        time.setText(record.getTime());
        systolic.setText(record.getSystolic());
        diastolic.setText(record.getDiastolic());
        heartRate.setText(record.getHeart_rate());
        comment.setText(record.getComment());
    }
}