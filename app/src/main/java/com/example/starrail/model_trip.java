package com.example.starrail;

public class model_trip implements java.io.Serializable{
    private String trip_name;
    private String trip_description;
    private double trip_price;
    public model_trip(String trip_name, String trip_description, double trip_price){
        this.trip_name = trip_name;
        this.trip_description = trip_description;
        this.trip_price = trip_price;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public String getTrip_description() {
        return trip_description;
    }

    public double getTrip_price() {
        return trip_price;
    }
}
