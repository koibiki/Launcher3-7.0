package com.android.predict.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by chengli on 17-12-26.
 */


public class PredictorSp {

    private static PredictorSp mPredictorSp;

    private final SharedPreferences mSp;

    private final String KEY_START_TRAIN = "key_start_train";


    private PredictorSp(Context context) {
        mSp = context.getSharedPreferences("predictor", Context.MODE_PRIVATE);
    }

    public synchronized static PredictorSp getInstance(Context context) {
        if (mPredictorSp == null) {
            mPredictorSp = new PredictorSp(context);
        }
        return mPredictorSp;
    }


    public synchronized void startTrain() {
        mSp.edit().putBoolean(KEY_START_TRAIN, true).apply();
    }


    public synchronized boolean isTrainning() {
        return mSp.getBoolean(KEY_START_TRAIN, false);
    }

}
