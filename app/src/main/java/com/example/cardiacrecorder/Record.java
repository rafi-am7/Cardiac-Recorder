package com.example.cardiacrecorder;

public class Record {
    //class elements
    private String date="01/01/2000";
    private String time="00.00";
    private int systolic=0;
    private int diastolic=0;
    private int heart_rate=0;
    private String comment="";

    //Constructor
    public Record(String date, String time, int systolic, int diastolic, int heart_rate, String comment) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heart_rate = heart_rate;
        this.comment = comment;
    }

    //Getters
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

    public int getHeart_rate() {
        return heart_rate;
    }

    public String getComment() {
        return comment;
    }

    //Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public void setHeart_rate(int heart_rate) {
        this.heart_rate = heart_rate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
