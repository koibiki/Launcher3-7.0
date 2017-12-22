package com.android.predict.presentation.internal.component;

import com.android.predict.AppTypeActivity;
import com.android.predict.presentation.internal.PerActivity;
import com.android.predict.presentation.internal.module.AppTypeModule;

import dagger.Component;
@PerActivity //必须加scope
@Component(dependencies = ApplicationComponent.class,modules = AppTypeModule.class)
public interface AppTypeComponent {
    void inject(AppTypeActivity activity);
}