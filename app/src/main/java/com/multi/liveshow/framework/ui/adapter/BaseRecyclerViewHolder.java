package com.multi.liveshow.framework.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;



public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

    protected View itemView;

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;

        ButterKnife.bind(this, itemView);
    }

    public View getItemView() {
        return itemView;
    }
}
