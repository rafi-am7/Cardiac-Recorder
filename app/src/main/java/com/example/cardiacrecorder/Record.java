package com.example.cardiacrecorder;

import android.os.Parcel;
import android.os.Parcelable;

public class Record implements Parcelable, Comparable<Record>{
    private String date="01/01/2000";
    private String time="00.00";
    private int systolic=0;
    private int diastolic=0;
    private int heartRate=0;
    private String comment="";

    //Constructor
    public Record(String date, String time, int systolic, int diastolic, int heart_rate, String comment) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heart_rate;
        this.comment = comment;
    }
    public Record() {

    }
    public Record(String date, String time, int systolic, int diastolic, int heart_rate) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heart_rate;
        this.comment = "";
    }

    protected Record(Parcel in) {
        date = in.readString();
        time = in.readString();
        systolic = in.readInt();
        diastolic = in.readInt();
        heartRate = in.readInt();
        comment = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(time);
        dest.writeInt(systolic);
        dest.writeInt(diastolic);
        dest.writeInt(heartRate);
        dest.writeString(comment);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };


    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }


    public int getSystolic() {
        return systolic;
    }


    public int getDiastolic() {
        return diastolic;
    }


    public int getHeartRate() {
        return heartRate;
    }

    public String getComment() {
        return comment;
    }



    /**
     * setter for date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * setter for time
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * setter for systolic
     * @param systolic
     */
    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    /**
     * setter for diastolic
     * @param diastolic
     */
    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    /**
     * setter for heart_rate
     * @param heart_rate
     */
    public void setHeart_rate(int heart_rate) {
        this.heartRate = heart_rate;
    }

    /**
     * setter for comment
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * function for comparison between dates for comparable
     * @param record
     * comparing records
     * @return
     *  returns 1 when greater, otherwise 0
     */
    @Override
    public int compareTo(Record record) {
        return this.date.compareTo(record.getDate());
    }
}
