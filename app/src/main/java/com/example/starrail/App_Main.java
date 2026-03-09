package com.example.starrail;

public class App_Main extends android.app.Application{
    public void onCreate(){
        super.onCreate();
        com.google.android.material.color.DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
