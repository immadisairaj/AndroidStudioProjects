package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude, mLocation, mDate, mUrl;

    public Earthquake(String mMagnitude, String mLocation, String mDate, String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mDate = mDate;
        this.mUrl = mUrl;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
