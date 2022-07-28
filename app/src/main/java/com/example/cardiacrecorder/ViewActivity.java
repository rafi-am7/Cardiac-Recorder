package com.example.cardiacrecorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;
    ArrayList<Record> recordsArrayList;
    Record record;

    TextView date,time,systolic,diastolic,heartRate,comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);
        //Toast.makeText(UpdateActivity.this,""+index,Toast.LENGTH_SHORT).show();

        date = findViewById(R.id.vDateValue);
        time = findViewById(R.id.vTimeValue);
        systolic = findViewById(R.id.vSystolicValue);
        diastolic = findViewById(R.id.vDiastolicValue);
        heartRate = findViewById(R.id.vHeartRateValue);
        comment = findViewById(R.id.vCommentValue);
        Button backButton = findViewById( R.id.backButton);
        retrieveData();

        record = recordsArrayList.get(index);

        date.setText(""+record.getDate());
        time.setText(""+record.getTime());
        systolic.setText(""+record.getSystolic());
        diastolic.setText(""+record.getDiastolic());
        heartRate.setText(""+record.getHeartRate());
        comment.setText(""+record.getComment());
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    /**
     * method for retrieving data from shared preference
     */
    private void retrieveData()
    {
        sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        gson = new Gson();
        String jsonString = sharedPreferences.getString("record",null);
        Type type = new TypeToken<ArrayList<Record>>(){}.getType();
        recordsArrayList = gson.fromJson(jsonString,type);
        if(recordsArrayList ==null)
        {
            recordsArrayList = new ArrayList<>();
        }
    }

}