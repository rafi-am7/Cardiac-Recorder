package com.example.cardiacrecorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this class to to create an array list for records
 */

public class RecordList {
    private List<Record> records = new ArrayList<>();

    /**
     * This method adds a record in the list
     * @param record
     *      the object which is going to be added to the list
     */
    public void addRecord (Record record) {
        if(records.contains(record)) {
            throw new IllegalArgumentException();
        } else {
            records.add(record);
        }
    }

    /**
     * This method deletes an existing method to the list
     * @param record
     *      the object which is going to be deleted from the list
     */
    public void deleteRecord (Record record) {
        if(records.contains(record)) {
            records.remove(record);
        } else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * This method is for returning a sorted list
     * @return
     *      returns a sorted list of records
     */
    public List<Record> sortRecords() {
        List<Record> recordList = records;
        Collections.sort(recordList);
        return recordList;
    }
}
