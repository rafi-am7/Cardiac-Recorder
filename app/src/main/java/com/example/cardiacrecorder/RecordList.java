package com.example.cardiacrecorder;

import java.util.ArrayList;
import java.util.List;

public class RecordList {
    private List<Record> records = new ArrayList<>();

    public void addRecord (Record record) {
        if(records.contains(record)) {
            throw new IllegalArgumentException();
        } else {
            records.add(record);
        }
    }

    public void deleteRecord (Record record) {
        if(records.contains(record)) {
            records.remove(record);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void updateRecord (Record old_record,String date, String time, int systolic, int diastolic, int heart_rate, String comment) {
        old_record.setDate(date);
        old_record.setTime(time);
        old_record.setSystolic(systolic);
        old_record.setDiastolic(diastolic);
        old_record.setHeart_rate(heart_rate);
        old_record.setComment(comment);
        //old_record = Record(date,time,systolic,diastolic,heart_rate,comment);
    }

    public void fetchListfromDB () {

    }
}
