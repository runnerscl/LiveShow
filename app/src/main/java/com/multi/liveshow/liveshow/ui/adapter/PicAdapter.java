package com.multi.liveshow.liveshow.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.base.AppConst;
import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.liveshow.ui.activity.CommunityDetailActivity;
import com.multi.liveshow.liveshow.ui.activity.PicDetailActivity;
import com.multi.liveshow.liveshow.ui.activity.ShowUserActivity;
import com.multi.liveshow.liveshow.widget.RoundImageView;
import com.multi.liveshow.liveshow.widget.ninelayout.NineGridTestLayout;
import com.multi.liveshow.liveshow.widget.ninelayout.OnItemPictureClickListener;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerAdapter;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerViewHolder;
import com.multi.liveshow.framework.ui.adapter.OnConvertViewClickListener;
import com.multi.liveshow   .framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;


public class PicAdapter extends BaseRecyclerAdapter<Community, PicAdapter.PicViewHolder> {

    public PicAdapter(Context context, List<Community> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(PicViewHolder holder, final Community data, int position) {
        holder.getItemView().setTag(holder.getItemView().getId(), position);
        holder.tvDes.setText(data.getDes());

        GlideUtils.show(context,data.getImageList().get(0),holder.ivBg,
                R.mipmap.loading_pic,R.mipmap.loading_pic);
    }

    @NonNull
    @Override
    public PicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pic_item, viewGroup, false);
        PicViewHolder holder = new PicViewHolder(view);
        OnConvertViewClickListener listener = new OnConvertViewClickListener(view, view.getId()) {
            @Override
            public void onClickCallBack(View clickView, int... positionIds) {
                int position = positionIds[0];
                Community community = datas.get(position);
                Intent intent = new Intent(context, PicDetailActivity.class);
                intent.putExtra(AppConst.KEY_2, community);
                context.startActivity(intent);
            }
        };
        holder.rlPicRoot.setOnClickListener(listener);
        return holder;
    }

    static class PicViewHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.rl_pic_root)
        RelativeLayout rlPicRoot;
        @BindView(R.id.tv_des)
        TextView tvDes;
        @BindView(R.id.iv_bg)
        RoundImageView ivBg;

        public PicViewHolder(View itemView) {
            super(itemView);
        }
    }

}
