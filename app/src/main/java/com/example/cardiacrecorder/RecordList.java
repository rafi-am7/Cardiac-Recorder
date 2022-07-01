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

    public void updateRecord (Record old_record,Record new_record) {
        old_record = new_record;
    }

    public void fetchListromDB () {

    }
}
