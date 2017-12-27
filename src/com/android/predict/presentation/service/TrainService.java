package com.android.predict.presentation.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.android.predict.LauncherApplication;
import com.android.predict.domain.interactor.action.Predictor;
import com.android.predict.presentation.internal.component.ApplicationComponent;
import com.android.predict.presentation.internal.component.DaggerTrainComponent;
import com.android.predict.utils.PredictorSp;

import javax.inject.Inject;

/**
 * Created by orien on 2017/12/13.
 */

public class TrainService extends IntentService {

    public TrainService() {
        super("TrainService");
    }

    @Inject
    Predictor mPredictor;

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        DaggerTrainComponent.builder().applicationComponent(getApplicationComponent()).build().inject(this);

        mPredictor.trainPredictModel();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PredictorSp.getInstance(this).finishTraining();
    }

    private ApplicationComponent getApplicationComponent() {
        return ((LauncherApplication) getApplication()).getApplicationComponent();
    }

    public static void startTrainService(Context context) {
        Intent intent = new Intent(context, TrainService.class);
        context.startService(intent);
    }

}
