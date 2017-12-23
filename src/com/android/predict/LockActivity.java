package com.android.predict;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.launcher3.R;
import com.android.predict.presentation.DaggerActivity;
import com.android.predict.presentation.LockReceiver;
import com.android.predict.presentation.internal.component.DaggerAppTypeComponent;
import com.android.predict.presentation.internal.module.AppTypeModule;
import com.android.predict.presentation.presenter.AppTypeContact;
import com.android.predict.presentation.presenter.AppTypePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
