package com.android.predict;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.android.predict.presentation.internal.component.ApplicationComponent;
import com.android.predict.presentation.internal.component.DaggerApplicationComponent;
import com.android.predict.presentation.internal.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by orien on 2017/12/12.
 */

public class LauncherApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initLeakcanary();
        initializeInjector();
        startService(new Intent(this, LightGbmService.class));
    }

    private void initLeakcanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    public Handler mHandler = new Handler(Looper.getMainLooper());

    public Handler getMainHandler() {
        return mHandler;
    }

}
