package com.anye.literature;


import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by zkk_g on 2017/7/20.
 */

public class CommonApp extends Application {
    public static  String version ;
    private static CommonApp sInstance;
    public static  String szImei="_test_";
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        PackageManager manager = this.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            version = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
