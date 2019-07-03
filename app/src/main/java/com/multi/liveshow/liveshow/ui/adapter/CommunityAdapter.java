package com.multi.liveshow.liveshow.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.base.AppConst;
import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.liveshow.ui.activity.CommunityDetailActivity;
import com.multi.liveshow.liveshow.ui.activity.ShowUserActivity;
import com.multi.liveshow.liveshow.widget.RoundImageView;
import com.multi.liveshow.liveshow.widget.ninelayout.NineGridTestLayout;
import com.multi.liveshow.liveshow.widget.ninelayout.OnItemPictureClickListener;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerAdapter;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerViewHolder;
import com.multi.liveshow.framework.ui.adapter.OnConvertViewClickListener;

import java.util.List;

import butterknife.BindView;


public class CommunityAdapter extends BaseRecyclerAdapter<Community, CommunityAdapter.CommunityHolder> {

    //图片点击监听回调
    private OnItemPictureClickListener listener;

    public CommunityAdapter(Context context, List<Community> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindViewHolder(CommunityHolder holder, final Community data, int position) {
        holder.getItemView().setTag(holder.getItemView().getId(), position);
        holder.tvDes.setText(data.getDes());
        holder.tvNick.setText(data.getNick());
        holder.roundImageHead.setImageResource(data.getHead());
        holder.nineGridTestLayout.setUrlList(data.getImageList());
        holder.nineGridTestLayout.setListener(listener);

        holder.roundImageHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowUserActivity.class);
                intent.putExtra(AppConst.KEY_1, data);
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public CommunityHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_community_item, viewGroup, false);
        CommunityHolder holder = new CommunityHolder(view);
        OnConvertViewClickListener listener = new OnConvertViewClickListener(view, view.getId()) {
            @Override
            public void onClickCallBack(View clickView, int... positionIds) {
                int position = positionIds[0];
                Community community = datas.get(position);
                Intent intent = new Intent(context, CommunityDetailActivity.class);
                intent.putExtra(AppConst.KEY_2, community);
                context.startActivity(intent);
            }
        };
        holder.llRootCommunity.setOnClickListener(listener);
        return holder;
    }

    static class CommunityHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.ll_root_community)
        LinearLayout llRootCommunity;
        @BindView(R.id.roundHead)
        RoundImageView roundImageHead;
        @BindView(R.id.tv_nick)
        TextView tvNick;
        @BindView(R.id.tv_des)
        TextView tvDes;
        @BindView(R.id.nine_images)
        NineGridTestLayout nineGridTestLayout;

        public CommunityHolder(View itemView) {
            super(itemView);
        }
    }


    public void setListener(OnItemPictureClickListener listener) {
        this.listener = listener;
    }
}
