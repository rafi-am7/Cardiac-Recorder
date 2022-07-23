package com.example.cardiacrecorder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;
    ArrayList<Record> recordsArrayList;
    Record record;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    EditText date,time,systolic,diastolic,heartRate,comment;
    Button saveButton;

    String dateStr,timeStr;

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

        saveButton = findViewById( R.id.saveButton);

        retrieveData();
       // datePicker();
     //   timePicker();

        saveButton.setOnClickListener(v -> {

            // store the returned value of the dedicated function which checks
            // whether the entered data is valid or if any fields are left blank.
            isAllFieldsChecked = CheckAllFields();

            // the boolean variable turns to be true then
            // only the user must be proceed to the activity2

            if (isAllFieldsChecked) {
                String dateString = date.getText().toString();
                String timeString = time.getText().toString();
                int sysInt = Integer.parseInt(systolic.getText().toString());
                int diasInt = Integer.parseInt(diastolic.getText().toString());
                int heartInt = Integer.parseInt(heartRate.getText().toString());
                String commentStr = comment.getText().toString();
                record = new Record(dateString,timeString,sysInt,diasInt,heartInt,commentStr);

                recordsArrayList.add(record);
                MainActivity.recordsArrayList.add(record);
                MainActivity.recordAdapter.notifyDataSetChanged();
                Toast.makeText(AddActivity.this,"Record added successfully!",Toast.LENGTH_SHORT).show();
                PreferenceManager.getDefaultSharedPreferences(this).edit().clear().commit();
                saveData();
                finish();
            }
        });
    }

    /**
     * This method if for validation of user input
     * @return
     *      returns true when user inserts valid data. otherwise returns false
     */
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
        if(n1<0 || n1>300)
        {
            systolic.setError("Invalid data input");
            return false;
        }

        if (diastolic.length() == 0) {
            diastolic.setError("This field is required");
            return false;
        }

        String formatDate = "^(0[1-9]|[12][0-9]|3[01]|[1-9])\\/(0[1-9]|1[0-2]|[1-9])\\/([12][0-9]{3})$";
        String formatTime = "^([01][0-9]|2[0-3])\\:([0-5][0-9])";
        String dateString = date.getText().toString();
        String timeString = time.getText().toString();
        Matcher matcherObj = Pattern.compile(formatDate).matcher(dateString);
        if (!matcherObj.matches()){
            date.setError("Please input in 'dd/mm/yyyy' format");
            return false;
        }
        Matcher matcherObj2 = Pattern.compile(formatTime).matcher(timeString);
        if (!matcherObj2.matches()){
            time.setError("Please input in 'hh:mm' format");
            return false;
        }
        String s2 = diastolic.getText().toString();
        int n2 = Integer.parseInt(s2);
        if(n2<0 || n2>200)
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

        if(n3<0 || n3>150)
        {
            heartRate.setError("Invalid data input");
            return false;
        }

        // after all validation return true if all required fields are inserted.
        return true;
    }

    /**
     * Method for getting a date from user through date picker
     */
    private void datePicker()
    {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(AddActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, onDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateStr = dayOfMonth + "-" + (month + 1) + "-" + year;
                date.setText(dateStr);
            }
        };
    }

    /**
     * Method for getting a time from user through time picker
     */
    private void timePicker() {
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hour =calendar.get(Calendar.HOUR_OF_DAY);
                int minute =calendar.get(Calendar.MINUTE);
                //calendar.clear();
                TimePickerDialog dialog =  new TimePickerDialog(AddActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeStr = hourOfDay + ":" +minute;
                        time.setText(timeStr);

                    }
                }, hour , minute,true);
                //  dialog.setTitle("Select Time");

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
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

    /**
     * method for saving data to shared preference
     */
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