package com.android.launcher3.predict;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by orien on 2017/12/13.
 */

public class LightGbmService extends IntentService {

    private static final String TAG = LightGbmService.class.getName();

    public LightGbmService() {
        super("LightGbmService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        TestJni.trainModel(this);
    }
}
