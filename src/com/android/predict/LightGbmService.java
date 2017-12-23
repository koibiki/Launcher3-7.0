package com.android.predict;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.android.predict.presentation.internal.component.ApplicationComponent;
import com.android.predict.presentation.internal.component.DaggerLightGbmComponent;

/**
 * Created by orien on 2017/12/13.
 */

public class LightGbmService extends IntentService {

    public LightGbmService() {
        super("LightGbmService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        DaggerLightGbmComponent.builder().applicationComponent(getApplicationComponent()).build().inject(this);
        long l = SystemClock.currentThreadTimeMillis();
        //TestJni.trainModel();

        Handler mainHandler = ((LauncherApplication) getApplication()).getMainHandler();

        mainHandler.post(() -> Toast.makeText(getApplication(), "spent:" + ((SystemClock.currentThreadTimeMillis() - l)/1000), Toast.LENGTH_SHORT).show());

    }

    private ApplicationComponent getApplicationComponent() {
        return ((LauncherApplication) getApplication()).getApplicationComponent();
    }

}
