package com.android.predict.presentation.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.android.predict.LauncherApplication;
import com.android.predict.presentation.internal.component.ApplicationComponent;
import com.android.predict.presentation.internal.component.DaggerTrainComponent;
import com.android.predict.utils.PredictorSp;

/**
 * Created by orien on 2017/12/13.
 */

public class TrainService extends IntentService {

    public TrainService() {
        super("TrainService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        DaggerTrainComponent.builder().applicationComponent(getApplicationComponent()).build().inject(this);
        long l = SystemClock.currentThreadTimeMillis();

        Handler mainHandler = ((LauncherApplication) getApplication()).getMainHandler();

        mainHandler.post(() -> Toast.makeText(getApplication(), "spent:" + ((SystemClock.currentThreadTimeMillis() - l) / 1000), Toast.LENGTH_SHORT).show());

    }

    private ApplicationComponent getApplicationComponent() {
        return ((LauncherApplication) getApplication()).getApplicationComponent();
    }

    public static void startLightGbmService(Context context) {
        if (!PredictorSp.getInstance(context).isTrainning()) {
            PredictorSp.getInstance(context).startTrain();
            Intent intent = new Intent(context, TrainService.class);
            context.startService(intent);
        }
    }

}
