package com.multi.liveshow.liveshow.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.entity.VideoData;
import com.kaha.dragon.dragon.widget.CustomVideoView;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerAdapter;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerViewHolder;

import java.util.List;

import butterknife.BindView;


public class VideoAdapter extends BaseRecyclerAdapter<VideoData, VideoAdapter.HomeViewHolder> {

    private OnItemClickListaner listaner;

    public VideoAdapter(Context context, List<VideoData> datas) {
        super(context, datas);
    }


    @Override
    protected void onBindViewHolder(final HomeViewHolder homeViewHolder, VideoData data, int position) {
        homeViewHolder.img_thumb.setImageBitmap(data.getBitmap());
        homeViewHolder.customVideoView.setVideoURI(Uri.parse(data.getPath()));
        homeViewHolder.rlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaner.onItemClick(homeViewHolder.ivPlay, homeViewHolder.customVideoView);
            }
        });
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_home_item, viewGroup, false);
        return new HomeViewHolder(view);
    }

    static class HomeViewHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.customVideoView)
        CustomVideoView customVideoView;
        @BindView(R.id.img_thumb)
        ImageView img_thumb;
        @BindView(R.id.rl_root)
        RelativeLayout rlRoot;
        @BindView(R.id.iv_play)
        ImageView ivPlay;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListaner listaner) {
        this.listaner = listaner;
    }


    public interface OnItemClickListaner {
        void onItemClick(ImageView imageView, CustomVideoView videoView);
    }

}
