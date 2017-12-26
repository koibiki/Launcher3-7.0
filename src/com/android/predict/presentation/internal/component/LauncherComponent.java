package com.android.predict.presentation.internal.component;

import com.android.launcher3.Launcher;
import com.android.predict.presentation.internal.PerActivity;
import com.android.predict.presentation.internal.module.LauncherModule;

import dagger.Component;

/**
 * Created by orien on 2017/12/23.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = LauncherModule.class)
public interface LauncherComponent {
    void inject(Launcher launcher);
}
