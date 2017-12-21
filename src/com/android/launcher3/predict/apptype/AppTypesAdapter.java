package com.android.launcher3.predict.apptype;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.launcher3.R;
import com.android.launcher3.predict.AppTypeActivity;
import com.android.launcher3.predict.Constants;

/**
 * Created by orien on 2017/12/21.
 */

public class AppTypesAdapter extends RecyclerView.Adapter<AppTypesAdapter.AppTypeHolder> {

    private final Context mContext;

    public AppTypesAdapter(Context context) {
        mContext = context;
    }

    @Override
    public AppTypesAdapter.AppTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.item_app_type, null);
        return new AppTypeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(AppTypeHolder holder, int position) {
        holder.bindData(position);
    }


    @Override
    public int getItemCount() {
        return Constants.TYPES.length;
    }

    static class AppTypeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        View mRoot;
        TextView mTvAppType;
        int mPosition;

        AppTypeHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mTvAppType = itemView.findViewById(R.id.tv_app_type);
        }

        void bindData(int position) {
            mTvAppType.setText(Constants.TYPES[position]);
            mPosition = position;
            mRoot.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mRoot.getContext(), AppTypeActivity.class);
            intent.putExtra(Constants.TYPE_POSITION, mPosition);
            mRoot.getContext().startActivity(intent);
        }
    }

}
