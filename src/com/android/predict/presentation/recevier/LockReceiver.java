package com.android.predict.presentation.recevier;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by orien on 2017/12/24.
 */

public class LockReceiver extends DeviceAdminReceiver {

    private final String TAG = this.getClass().getName();

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.w(TAG, "Receiver : " + intent.getAction());
    }
}
