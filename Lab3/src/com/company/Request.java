package com.company;

public class Request {
    private String country;
    private int month;
    private int starDay;
    private int endDay;

    Request(String country, int month, int from, int to){
        this.country = country;
        this.month = 0;
        this.starDay = 0;
        this.endDay = 0;
    }

    public String getCountry() {
        return country;
    }

    public int getMonth() {
        return month;
    }

    public int getStarDay() {
        return starDay;
    }

    public int getEndDay(){
        return endDay;
    }
}
