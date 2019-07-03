package com.multi.liveshow.liveshow.ui.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.liveshow.entity.HotPic;
import com.multi.liveshow.liveshow.widget.RoundImageView;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerAdapter;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerViewHolder;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


public class HotPicAdapter extends BaseRecyclerAdapter<HotPic, HotPicAdapter.HotPicHolder> {

    public HotPicAdapter(Context context, List<HotPic> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(HotPicHolder holder, HotPic data, int position) {
        holder.textView.setText(data.getNick());
        holder.circleImageView.setImageResource(data.getHead());
        holder.imageView.setImageResource(data.getImage());
        holder.tvLikeNumber.setText("" + data.getLikeCount());
    }

    @NonNull
    @Override
    public HotPicHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_hot_pic_item, viewGroup, false);
        return new HotPicHolder(view);
    }

    static class HotPicHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.iv_image)
        RoundImageView imageView;
        @BindView(R.id.iv_head)
        CircleImageView circleImageView;
        @BindView(R.id.tv_nick)
        TextView textView;
        @BindView(R.id.like_number)
        TextView tvLikeNumber;

        public HotPicHolder(View itemView) {
            super(itemView);
        }
    }

}
