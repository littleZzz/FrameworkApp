package com.boyacx.frameworkapp.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

/**
 * @author littleZ
 */

public class MyApplication extends Application {

    public static Context appContext;
    public static ArrayList<Activity> allActivities = new ArrayList<Activity>();
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        app = this;
    }

    public static Context getConText() {
        return appContext;
    }

    public static MyApplication getApp() {
        return app;
    }

    public static void addActivity(Activity activity) {
        allActivities.add(activity);
    }

    public static void delActivity(Activity activity) {
        allActivities.remove(activity);
    }

}
