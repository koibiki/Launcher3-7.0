package com.android.predict.presentation.internal.module;

import android.app.Activity;

import com.android.predict.presentation.internal.PerActivity;
import com.android.predict.presentation.presenter.AppTypeContact;

import dagger.Module;
import dagger.Provides;

@Module
public class AppTypeModule {
    private final AppTypeContact.View mView;
    private final Activity activity;

    public AppTypeModule(Activity activity,AppTypeContact.View view) {
        this.activity = activity;
        mView = view;
    }

    @Provides
    AppTypeContact.View provideMainView() {
        return mView;
    }
}

