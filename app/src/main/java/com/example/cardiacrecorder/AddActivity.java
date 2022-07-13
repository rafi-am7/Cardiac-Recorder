package com.example.cardiacrecorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;
    ArrayList<Record> recordsArrayList;
    Record record;
    EditText date,time,systolic,diastolic,heartRate,comment;
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        date = findViewById(R.id.dateValue);
        time = findViewById(R.id.timeValue);
        systolic = findViewById(R.id.systolicValue);
        diastolic = findViewById(R.id.diastolicValue);
        heartRate = findViewById(R.id.heartRateValue);
        comment = findViewById(R.id.commentValue);
        Button saveButton = findViewById( R.id.addButton);
        retrieveData();

        saveButton.setOnClickListener(v -> {

            // store the returned value of the dedicated function which checks
            // whether the entered data is valid or if any fields are left blank.
            isAllFieldsChecked = CheckAllFields();

            // the boolean variable turns to be true then
            // only the user must be proceed to the activity2

            if (isAllFieldsChecked) {
                String dateStr = date.getText().toString();
                String timeStr = time.getText().toString();
                int sysInt = Integer.parseInt(systolic.getText().toString());
                int diasInt = Integer.parseInt(diastolic.getText().toString());
                int heartInt = Integer.parseInt(heartRate.getText().toString());
                String commentStr = comment.getText().toString();
                record = new Record(dateStr,timeStr,sysInt,diasInt,heartInt,commentStr);

                recordsArrayList.add(record);
                Toast.makeText(this,"Saving Records...",Toast.LENGTH_SHORT).show();
                PreferenceManager.getDefaultSharedPreferences(this).edit().clear().commit();
                saveData();


               Intent i = new Intent(AddActivity.this, MainActivity.class);
               // i.putExtra("New Record", record);
                startActivity(i);
                finish();
            }
        });
    }

    private boolean CheckAllFields() {
        if (date.length() == 0) {
            date.setError("This field is required");
            return false;
        }

        if (time.length() == 0) {
            time.setError("This field is required");
            return false;
        }

        if (systolic.length() == 0) {
            systolic.setError("This field is required");
            return false;
        }

        String s1 = systolic.getText().toString();
        int n1 = Integer.parseInt(s1);
        if(n1<0)
        {
            systolic.setError("Invalid data input");
            return false;
        }

        if (diastolic.length() == 0) {
            diastolic.setError("This field is required");
            return false;
        }

        String s2 = diastolic.getText().toString();
        int n2 = Integer.parseInt(s2);
        if(n2<0)
        {
            diastolic.setError("Invalid data input");
            return false;
        }

        if (heartRate.length() == 0) {
            heartRate.setError("This field is required");
            return false;
        }

        String s3 = heartRate.getText().toString();
        int n3 = Integer.parseInt(s3);

        if(n3<0)
        {
            heartRate.setError("Invalid data input");
            return false;
        }

        // after all validation return true if all required fields are inserted.
        return true;
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
            recordsArrayList = new ArrayList<>();
        }
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
}