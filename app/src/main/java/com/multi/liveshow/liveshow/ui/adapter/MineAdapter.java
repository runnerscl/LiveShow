package com.multi.liveshow.liveshow.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.entity.Mine;
import com.multi.liveshow.liveshow.ui.activity.ShowUserActivity;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerAdapter;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerViewHolder;
import com.multi.liveshow.framework.ui.adapter.OnConvertViewClickListener;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


public class MineAdapter extends BaseRecyclerAdapter<Mine, MineAdapter.MineViewHolder> {


    public MineAdapter(Context context, List<Mine> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(MineViewHolder holder, Mine data, int position) {
        holder.cvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               context.startActivity(new Intent(context,ShowUserActivity.class));
            }
        });
    }

    @NonNull
    @Override
    public MineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_mine_item, viewGroup, false);
        MineAdapter.MineViewHolder holder = new MineAdapter.MineViewHolder(view);

        OnConvertViewClickListener clickListener = new OnConvertViewClickListener(view, view.getId()) {
            @Override
            public void onClickCallBack(View clickView, int... positionIds) {

            }
        };
        return holder;
    }

    static class MineViewHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.cv_head)
        CircleImageView cvHead;

        public MineViewHolder(View itemView) {
            super(itemView);
        }
    }
}
