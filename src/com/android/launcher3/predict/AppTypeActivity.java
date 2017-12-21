package com.android.launcher3.predict;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.launcher3.AllAppsList;
import com.android.launcher3.AppInfo;
import com.android.launcher3.FastBitmapDrawable;
import com.android.launcher3.Launcher;
import com.android.launcher3.LauncherAppState;
import com.android.launcher3.R;
import com.android.launcher3.compat.LauncherActivityInfoCompat;
import com.android.launcher3.compat.LauncherAppsCompat;
import com.android.launcher3.compat.UserHandleCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orien on 2017/12/21.
 */

public class AppTypeActivity extends Activity {

    private AppsAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = new RecyclerView(this);
        setContentView(recyclerView);
        int position = getIntent().getIntExtra(Constants.TYPE_POSITION, 0);
        setTitle(Constants.TYPES[position]);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new AppsAdapter();
        recyclerView.setAdapter(mAdapter);


        new Thread(() -> {

            LauncherAppsCompat instance = LauncherAppsCompat.getInstance(AppTypeActivity.this);
            List<LauncherActivityInfoCompat> activityList = instance.getActivityList(null, UserHandleCompat.myUserHandle());

            AllAppsList allAppsList = LauncherAppState.getInstance().getModel().getBgAllAppsList();



            for (AppInfo appInfo : allAppsList.data) {
                String packageName = appInfo.componentName.getPackageName();
            }
            runOnUiThread(() -> {
//                mAdapter.setData();
            });

        }).start();

    }

    static class AppsAdapter extends RecyclerView.Adapter<AppItemHolder> {

        List<AppInfo> mList = new ArrayList<>();

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

        void setData(List<AppInfo> list) {
            mList.clear();
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    static class AppItemHolder extends RecyclerView.ViewHolder {

        private final TextView mTvAppName;
        private final ImageView mIvIcon;
        private final CheckBox mCb;

        AppItemHolder(View itemView) {
            super(itemView);
            mTvAppName = itemView.findViewById(R.id.tv_app_name);
            mIvIcon = itemView.findViewById(R.id.iv_icon);
            mCb = itemView.findViewById(R.id.cb);
        }

        void bindData(AppInfo appInfo) {
            mTvAppName.setText(appInfo.title);

            mIvIcon.setImageBitmap(appInfo.iconBitmap);
        }

    }

}
