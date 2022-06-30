package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText date,time,systolic,diastolic,heart_rate,comment;
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        Record record = intent.getParcelableExtra("Old record");

        date = findViewById(R.id.DateValue2);
        time = findViewById(R.id.TimeValue2);
        systolic = findViewById(R.id.SystolicValue2);
        diastolic = findViewById(R.id.DiastolicValue2);
        heart_rate = findViewById(R.id.HeartRateValue2);
        comment = findViewById(R.id.CommentValue2);
        Button update_button = findViewById(R.id.updatebutton);

        date.setText(record.getDate());
        time.setText(record.getTime());
        systolic.setText(record.getSystolic());
        diastolic.setText(record.getDiastolic());
        heart_rate.setText(record.getHeart_rate());
        comment.setText(record.getComment());

        update_button.setOnClickListener(v -> {

            // store the returned value of the dedicated function which checks
            // whether the entered data is valid or if any fields are left blank.
            isAllFieldsChecked = CheckAllFields();

            // the boolean variable turns to be true then
            // only the user must be proceed to the activity2
            if (isAllFieldsChecked) {
                record.setDate(date.getText().toString());
                record.setTime(time.getText().toString());
                record.setSystolic(Integer.parseInt(systolic.getText().toString()));
                record.setDiastolic(Integer.parseInt(diastolic.getText().toString()));
                record.setHeart_rate(Integer.parseInt(heart_rate.getText().toString()));
                record.setComment(comment.getText().toString());
                Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                i.putExtra("New Record", record);
                startActivity(i);
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

        if (heart_rate.length() == 0) {
            heart_rate.setError("This field is required");
            return false;
        }

        String s3 = heart_rate.getText().toString();
        int n3 = Integer.parseInt(s3);

        if(n3<0)
        {
            heart_rate.setError("Invalid data input");
            return false;
        }

        // after all validation return true if all required fields are inserted.
        return true;
    }
}