package com.android.predict.presentation.internal.component;

import android.content.Intent;

import com.android.predict.presentation.activity.AppTypeActivity;
import com.android.predict.presentation.internal.PerActivity;
import com.android.predict.presentation.internal.module.AppTypeModule;
import com.android.predict.presentation.presenter.AppTypeContact;

import dagger.Component;

@PerActivity //必须加scope
@Component(dependencies = ApplicationComponent.class, modules = AppTypeModule.class)
public interface AppTypeComponent {
    void inject(AppTypeActivity activity);

    AppTypeContact.View provideView();

    Intent provideIntent();

}