package com.android.predict.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.launcher3.R;
import com.android.predict.model.AppTypeInfo;
import com.android.predict.Constants;
import com.android.predict.presentation.internal.component.DaggerAppTypeComponent;
import com.android.predict.presentation.internal.module.AppTypeModule;
import com.android.predict.presentation.presenter.AppTypeContact;
import com.android.predict.presentation.presenter.AppTypePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by orien on 2017/12/21.
 */

public class AppTypeActivity extends DaggerActivity implements AppTypeContact.View {

    private AppsAdapter mAdapter;

    @Inject
    AppTypePresenter mAppTypePresent;

    private ProgressBar mPb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_type_selection);
        initializeInjector(getIntent());
        initView();
    }

    private void initView() {
        int typePosition = getIntent().getIntExtra(Constants.TYPE_POSITION, 0);
        RecyclerView recyclerView = findViewById(R.id.rv);
        mPb = findViewById(R.id.pb);
        setTitle(Constants.TYPES[typePosition]);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new AppsAdapter();
        recyclerView.setAdapter(mAdapter);
        mAppTypePresent.getAllAppType();
    }

    private void initializeInjector(Intent intent) {
        DaggerAppTypeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .appTypeModule(new AppTypeModule(this, intent))
                .build()
                .inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAppTypePresent.cancel();
        List<AppTypeInfo> data = mAdapter.getData();
        mAppTypePresent.saveAppTypeData(data);
    }

    @Override
    public void loadSuccess(List<AppTypeInfo> appTypeInfos) {
        mPb.setVisibility(View.GONE);
        mAdapter.setData(appTypeInfos);
    }

    class AppsAdapter extends RecyclerView.Adapter<AppItemHolder> {

        List<AppTypeInfo> mList = new ArrayList<>();

        @Override
        public AppItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = View.inflate(parent.getContext(), R.layout.item_app, null);
            return new AppItemHolder(inflate);
        }

        @Override
        public void onBindViewHolder(AppItemHolder holder, int position) {
            holder.bindData(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        void setData(List<AppTypeInfo> appTypeInfos) {
            mList.clear();
            mList.addAll(appTypeInfos);
            notifyDataSetChanged();
        }

        List<AppTypeInfo> getData() {
            return mList;
        }
    }

    class AppItemHolder extends RecyclerView.ViewHolder {

        private final View mRoot;
        private final TextView mTvAppName;
        private final ImageView mIvIcon;
        private final CheckBox mCb;

        AppItemHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mTvAppName = itemView.findViewById(R.id.tv_app_name);
            mIvIcon = itemView.findViewById(R.id.iv_icon);
            mCb = itemView.findViewById(R.id.cb);
        }

        void bindData(AppTypeInfo appInfo) {
            mTvAppName.setText(appInfo.getAppName());
            mIvIcon.setImageBitmap(appInfo.getIconBitmap());
            mCb.setChecked(appInfo.getTypeStatus());
            mRoot.setOnClickListener(v -> {
                appInfo.setTypeStatus(!appInfo.getTypeStatus());
                mCb.setChecked(appInfo.getTypeStatus());
            });
        }

    }

}
