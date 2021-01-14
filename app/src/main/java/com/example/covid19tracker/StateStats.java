package com.example.covid19tracker;

public class StateStats {

    private String mStateName;
    private int mTodayCases;
    private int mTodayRecovered;
    private int mTodayDeaths;
    private int mTotalCases;
    private int mTotalRecovered;

    public StateStats(String stateName, int todayCases, int todayDeaths, int todayRecovered, int totalCases, int totalRecovered) {
        mStateName = stateName;
        mTodayCases = todayCases;
        mTodayDeaths = todayDeaths;
        mTodayRecovered = todayRecovered;
        mTotalCases = totalCases;
        mTotalRecovered = totalRecovered;
    }

    public String getStateName() {
        return mStateName;
    }

    public int getTodayCases() {
        return mTodayCases;
    }

    public int getTodayRecovered() {
        return mTodayRecovered;
    }

    public int getTodayDeaths() {
        return  mTodayDeaths;
    }

    public int getTotalCases() {
        return mTotalCases;
    }

    public int getTotalRecovered() {
        return mTotalRecovered;
    }
}
