package com.android.predict.presentation.internal.module;

import android.content.Intent;

import com.android.predict.presentation.presenter.AppTypeContact;

import dagger.Module;
import dagger.Provides;

@Module
public class AppTypeModule {
    private final AppTypeContact.View mView;
    private final Intent mIntent;

    public AppTypeModule(AppTypeContact.View view, Intent intent) {
        mView = view;
        mIntent = intent;
    }

    @Provides
    AppTypeContact.View provideView() {
        return mView;
    }

    @Provides
    Intent provideIntent() {
        return mIntent;
    }

}

