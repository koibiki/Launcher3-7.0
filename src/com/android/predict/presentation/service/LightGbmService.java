package com.android.predict.presentation.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.android.predict.Constants;
import com.android.predict.LauncherApplication;
import com.android.predict.domain.interactor.action.Predictor;
import com.android.predict.presentation.internal.component.ApplicationComponent;
import com.android.predict.presentation.internal.component.DaggerLightGbmComponent;
import com.android.predict.utils.PredictorSp;

import javax.inject.Inject;

/**
 * Created by orien on 2017/12/13.
 */

public class LightGbmService extends IntentService {

    public LightGbmService() {
        super("LightGbmService");
    }

    @Inject
    Predictor mPredictor;

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        DaggerLightGbmComponent.builder().applicationComponent(getApplicationComponent()).build().inject(this);
        String action = intent.getAction();
        if (TextUtils.equals(action, Constants.ACTION_TRAIN)) {
            mPredictor.trainModel();
        } else if (TextUtils.equals(action, Constants.ACTION_PREDICT)) {
            mPredictor.predict();
        }

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
        Intent intent = new Intent(context, LightGbmService.class);
        intent.putExtra(Constants.ACTION_SERVICE, Constants.ACTION_TRAIN);
        context.startService(intent);
    }

    public static void startPredictService(Context context) {
        Intent intent = new Intent(context, LightGbmService.class);
        intent.putExtra(Constants.ACTION_SERVICE, Constants.ACTION_PREDICT);
        context.startService(intent);
    }

}
