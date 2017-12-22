package com.android.predict.presentation.internal.component;

import com.android.predict.LightGbmService;
import com.android.predict.presentation.internal.PerService;
import com.android.predict.presentation.internal.module.LightGbmModule;

import dagger.Component;

@PerService //必须加scope
@Component(dependencies = ApplicationComponent.class, modules = LightGbmModule.class)
public interface LightGbmComponent {
    void inject(LightGbmService service);

}