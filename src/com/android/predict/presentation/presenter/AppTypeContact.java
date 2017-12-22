package com.android.predict.presentation.presenter;

/**
 * Created by chengli on 17-12-22.
 */

public interface AppTypeContact {

    interface Presenter {
        void loadData();
    }

    interface View {
        void loadSuccess();
    }
}
