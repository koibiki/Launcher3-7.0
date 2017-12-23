package com.android.predict.presentation.activity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.predict.presentation.activity.DaggerActivity;
import com.android.predict.presentation.recevier.LockReceiver;

/**
 * Created by orien on 2017/12/21.
 */

public class LockActivity extends DaggerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lockScreen();
    }

    public void lockScreen() {

        DevicePolicyManager dpm = (DevicePolicyManager)
                getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(),
                LockReceiver.class);
        if (dpm != null && dpm.isAdminActive(componentName)) {
            dpm.lockNow();
        } else {
            activeManager(componentName);
        }
        finish();

    }

    private void activeManager(ComponentName componentName) {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "一键锁屏");
        startActivity(intent);
    }

}
