package com.anye.literature.baseapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhouke on 2017/7/25.
 */

public class BaseApplication extends Application  {
    private static BaseApplication baseApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }
    public static Context getAppContext() {
        return baseApplication;
    }
}
