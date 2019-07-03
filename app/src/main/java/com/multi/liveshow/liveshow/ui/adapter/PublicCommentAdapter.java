package com.multi.liveshow.liveshow.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerAdapter;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerViewHolder;

import java.util.List;


public class PublicCommentAdapter extends BaseRecyclerAdapter<Community, PublicCommentAdapter.PublicCommentHolder> {


    public PublicCommentAdapter(Context context, List<Community> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(PublicCommentHolder holder, Community data, int position) {

    }

    @NonNull
    @Override
    public PublicCommentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    static class PublicCommentHolder extends BaseRecyclerViewHolder {

        public PublicCommentHolder(View itemView) {
            super(itemView);
        }
    }
}
