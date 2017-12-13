package com.android.launcher3;

import android.app.Application;

import com.android.launcher3.behavior.GreenDaoInstance;
import com.android.launcher3.database.User;

import java.util.List;

/**
 * Created by orien on 2017/12/12.
 */

public class LauncherApplication extends Application {

    private static Application sInstance;

    public static Application getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        GreenDaoInstance instance = GreenDaoInstance.getInstance();
        List<User> users = instance.getUserDao().loadAll();
        TestJni.testJni();
    }
}
