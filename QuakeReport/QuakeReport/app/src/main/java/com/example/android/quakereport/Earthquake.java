package com.example.android.quakereport;

/**
 * Created by Orinayo on 28/02/2018.
 */

public class Earthquake {
    private double mMagnitude;
    private String mCity;
    private long mTimeInMilliseconds;
    private String mUrl;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param city is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *  earthquake happened
     */

    public Earthquake (double magnitude, String city, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mCity = city;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getCity(){
        return mCity;
    }

    public long getTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }

    public String getUrl(){
        return mUrl;
    }
}