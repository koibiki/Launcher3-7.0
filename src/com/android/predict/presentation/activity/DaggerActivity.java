package com.android.predict.presentation.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.predict.LauncherApplication;
import com.android.predict.presentation.internal.component.ApplicationComponent;

/**
 * Created by chengli on 17-12-22.
 */

@SuppressLint("Registered")
public class DaggerActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectApplication();
    }

    private void injectApplication() {
        getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((LauncherApplication) getApplication()).getApplicationComponent();
    }

}
