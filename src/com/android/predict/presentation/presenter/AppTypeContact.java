package com.android.predict.presentation.presenter;

import com.android.predict.AppTypeInfo;

import java.util.List;

/**
 * Created by chengli on 17-12-22.
 */

public interface AppTypeContact {

    interface Presenter {
        void getAllAppType();

        void cancel();

        void saveAppTypeData(List<AppTypeInfo> appTypeInfos);
    }

    interface View {
        void loadSuccess(List<AppTypeInfo> appTypeInfos);
    }
}
