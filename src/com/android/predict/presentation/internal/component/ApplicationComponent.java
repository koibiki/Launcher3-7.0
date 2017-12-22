package com.android.predict.presentation.internal.component;

import android.content.Context;

import com.android.predict.domain.excutor.PostExecutionThread;
import com.android.predict.database.Database;
import com.android.predict.presentation.DaggerActivity;
import com.android.predict.presentation.internal.module.ApplicationModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(DaggerActivity activity);

    Context context();

    Executor threadExecutor();

    PostExecutionThread postExecutionThread();

    Database provideDataBase();

}
