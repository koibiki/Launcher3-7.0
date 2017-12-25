package com.android.predict.domain.excutor;

import io.reactivex.Scheduler;

/**
 * Created by orien on 2017/12/25.
 */

public interface DaoExecutor {
    Scheduler getScheduler();
}
