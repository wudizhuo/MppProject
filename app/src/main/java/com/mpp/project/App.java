package com.mpp.project;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context applicationContext;
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this.getApplicationContext();
        app = this;
    }

    public static App getApp() {
        return app;
    }

    public static Context getContext() {
        return applicationContext;
    }
}
