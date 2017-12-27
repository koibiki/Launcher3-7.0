package com.android.predict.presentation.internal.component;

import com.android.predict.presentation.internal.module.LightGbmModule;
import com.android.predict.presentation.service.LightGbmService;
import com.android.predict.presentation.internal.PerService;

import dagger.Component;

@PerService //必须加scope
@Component(dependencies = ApplicationComponent.class, modules = LightGbmModule.class)
public interface LightGbmComponent {
    void inject(LightGbmService service);

}