package com.android.predict.domain.excutor;

import io.reactivex.Scheduler;

public interface PostExecutor {
    Scheduler getScheduler();
}
