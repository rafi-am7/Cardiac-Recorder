package com.example.cardiacrecorder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecordListUnitTest {

    /**
     * testing addRecord method
     */
    @Test
    public void testAddRecord() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);
        assertEquals(1, recordList.sortRecords().size());

        Record record2 = new Record("13-2-2000","05:30",120,97,78,"other");
        recordList.addRecord(record2);
        assertEquals(2, recordList.sortRecords().size());

        assertTrue(recordList.sortRecords().contains(record1));
        assertTrue(recordList.sortRecords().contains(record2));
    }

    /**
     * testing deleteRecord method
     */
    @Test
    public void testDeleteRecord() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);
        assertEquals(1, recordList.sortRecords().size());

        Record record2 = new Record("17-2-2000","9:20",120,97,78,"other");
        recordList.addRecord(record2);
        assertEquals(2, recordList.sortRecords().size());

        assertTrue(recordList.sortRecords().contains(record1));
        assertTrue(recordList.sortRecords().contains(record2));

        recordList.deleteRecord(record1);
        assertEquals(1, recordList.sortRecords().size());
        assertFalse(recordList.sortRecords().contains(record1));

        recordList.deleteRecord(record2);
        assertEquals(0, recordList.sortRecords().size());
        assertFalse(recordList.sortRecords().contains(record2));
    }

    /**
     * testing addRecord method for exceptions
     */
    @Test
    public void testAddRecordException() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);

        assertThrows(IllegalArgumentException.class, () -> recordList.addRecord(record1));
    }

    /**
     * testing deleteRecord method for exceptions
     */
    @Test
    public void testDeleteRecordException() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);

        recordList.deleteRecord(record1);

        assertThrows(IllegalArgumentException.class, () -> recordList.deleteRecord(record1));
    }

    /**
     * testing sortRecords method
     */
    @Test
    public void testSortRecords() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("13-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);

        assertEquals(0, record1.compareTo(recordList.sortRecords().get(0)));

        Record record2 = new Record("10-1-2000","9:20",120,97,78,"other");
        recordList.addRecord(record2);

        assertEquals(0, record2.compareTo(recordList.sortRecords().get(0)));
        assertEquals(0, record1.compareTo(recordList.sortRecords().get(1)));
    }
}
