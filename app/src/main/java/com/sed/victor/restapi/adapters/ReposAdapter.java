package com.sed.victor.restapi.adapters;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.sed.victor.restapi.R;
import com.sed.victor.restapi.model.Repo;

import java.util.List;

/**
 * Created by java on 07.12.2016.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {

    private List<Repo> mDataSource = null;

    private View.OnClickListener mOnItemClickListener;

    private View.OnLongClickListener mOnItemLongClickListener;

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        mOnItemLongClickListener = onLongClickListener;
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        mOnItemClickListener = onClickListener;
    }

    public void setDataSource(List<Repo> list) {
        mDataSource = list;
        notifyDataSetChanged();
    }



    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.repo_item, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        final Repo repo = mDataSource.get(position);
        holder.bind(repo);
        holder.itemView.setOnClickListener(mOnItemClickListener);
        holder.itemView.setOnLongClickListener(mOnItemLongClickListener);
    }

    @Override
    public int getItemCount() {
        return mDataSource == null ? 0 : mDataSource.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public RepoViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }

        private void bind(@NonNull Repo repo ) {
            textView.setText(repo.getName());

        }

    }
}





