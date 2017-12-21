package com.android.launcher3;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;


import com.android.launcher3.predict.LightGbmService;
import com.android.launcher3.predict.behavior.GreenDaoInstance;
import com.android.launcher3.predict.database.User;

import java.util.List;

/**
 * Created by orien on 2017/12/12.
 */

public class LauncherApplication extends Application {

    private String TAG = LauncherApplication.class.getName();
    private static LauncherApplication sInstance;

    private Handler mHandler = new Handler();

    public static LauncherApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        GreenDaoInstance instance = GreenDaoInstance.getInstance();
        List<User> users = instance.getUserDao().loadAll();
        startService(new Intent(this, LightGbmService.class));
    }

    public Handler getMainHandler() {
        return mHandler;
    }

}
