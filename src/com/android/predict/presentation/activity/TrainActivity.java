package com.android.predict.presentation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.launcher3.R;
import com.android.predict.presentation.service.TrainService;

/**
 * Created by chengli on 17-12-26.
 */

public class TrainActivity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);


    }

    public void startTrain(View view) {
        TrainService.startTrainService(this);
    }
}
