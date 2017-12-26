package com.android.predict.presentation.internal.component;

import com.android.predict.presentation.internal.module.TrainModule;
import com.android.predict.presentation.service.TrainService;
import com.android.predict.presentation.internal.PerService;

import dagger.Component;

@PerService //必须加scope
@Component(dependencies = ApplicationComponent.class, modules = TrainModule.class)
public interface TrainComponent {
    void inject(TrainService service);

}