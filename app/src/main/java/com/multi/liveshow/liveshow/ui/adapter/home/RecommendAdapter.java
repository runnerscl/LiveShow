package com.multi.liveshow.liveshow.ui.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragAndDropPermissions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.liveshow.entity.HotPic;
import com.multi.liveshow.liveshow.ui.activity.CircleActivity;
import com.multi.liveshow.liveshow.utils.EchelonLayoutManager;
import com.multi.liveshow.liveshow.widget.RoundImageView;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerAdapter;
import com.multi.liveshow.framework.ui.adapter.BaseRecyclerViewHolder;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //头布局
    public static final int HEAD_VIEW = 0;

    public static final int BODY_VIEW = 1;

    private HeadAdapter headAdapter;

    private List<HotPic> list;

    private Context context;

    private List<Community> datas;

    public RecommendAdapter(Context context, List<Community> datas, List<HotPic> list) {
        this.context = context;
        this.datas = datas;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == HEAD_VIEW) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_recommend_head_item, viewGroup, false);
            return new RecommendHeadHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_recommend_item, viewGroup, false);
            return new RecommendHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if (holder instanceof RecommendHolder) {
            ((RecommendHolder) holder).tvNick.setText(datas.get(i - 1).getNick());
//        GlideUtils.show(context,data.getHead(),holder.cvHead,
//                R.mipmap.loading_pic,R.mipmap.loading_pic);
            ((RecommendHolder) holder).cvHead.setImageResource(datas.get(i - 1).getHead());
            ((RecommendHolder) holder).imageView.setImageResource(datas.get(i - 1).getImageList().get(0));
        } else if (holder instanceof RecommendHeadHolder) {
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((RecommendHeadHolder) holder).rvCircle.setLayoutManager(manager);
            headAdapter = new HeadAdapter(context, null);
            ((RecommendHeadHolder) holder).rvCircle.setAdapter(headAdapter);
            headAdapter.updateData(list);
            ((RecommendHeadHolder) holder).tvMoreCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CircleActivity.class));
                }
            });

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        } else {
            return BODY_VIEW;
        }
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    static class RecommendHolder extends BaseRecyclerViewHolder {
        @BindView(R.id.cv_head)
        CircleImageView cvHead;
        @BindView(R.id.tv_nickName)
        TextView tvNick;
        @BindView(R.id.image)
        ImageView imageView;

        public RecommendHolder(View itemView) {
            super(itemView);
        }
    }


    class RecommendHeadHolder extends BaseRecyclerViewHolder {

        @BindView(R.id.rv_circle)
        RecyclerView rvCircle;
        @BindView(R.id.tv_more_circle)
        TextView tvMoreCircle;

        public RecommendHeadHolder(View itemView) {
            super(itemView);
        }
    }



    class HeadAdapter extends BaseRecyclerAdapter<HotPic, HeadAdapter.HeadHolder> {
        public HeadAdapter(Context context, List<HotPic> datas) {
            super(context, datas);
        }

        @Override
        protected void onBindViewHolder(HeadHolder holder, HotPic data, int position) {
            holder.imageView.setImageResource(data.getImage());
            holder.textView.setText("#" + data.getNick());
        }

        @NonNull
        @Override
        public HeadHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_recommend_item_head_item, viewGroup, false);
            return new HeadHolder(view);
        }

        class HeadHolder extends BaseRecyclerViewHolder {

            @BindView(R.id.image)
            RoundImageView imageView;
            @BindView(R.id.text)
            TextView textView;

            public HeadHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
