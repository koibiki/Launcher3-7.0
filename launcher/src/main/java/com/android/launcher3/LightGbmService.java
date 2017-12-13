package com.android.launcher3;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

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
        Log.w(TAG, "NEW thread:" + Thread.currentThread().getName());
        TestJni.predictJni();
    }
}
