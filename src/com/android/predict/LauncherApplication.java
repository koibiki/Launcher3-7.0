package com.android.predict;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;

import com.android.predict.presentation.internal.component.ApplicationComponent;
import com.android.predict.presentation.internal.component.DaggerApplicationComponent;
import com.android.predict.presentation.internal.module.ApplicationModule;

/**
 * Created by orien on 2017/12/12.
 */

public class LauncherApplication extends Application {

    private String TAG = LauncherApplication.class.getName();

    private ApplicationComponent applicationComponent;

    private static LauncherApplication sInstance;

    private Handler mHandler = new Handler();

    public static LauncherApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initializeInjector();
        startService(new Intent(this, LightGbmService.class));
    }

    public Handler getMainHandler() {
        return mHandler;
    }

    private void initializeInjector() {

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
