
package com.multi.liveshow.liveshow.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.entity.Mine;
import com.multi.liveshow.liveshow.ui.adapter.MineAdapter;
import com.multi.liveshow.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class PublicCommentFragment extends BaseFragment {

    @BindView(R.id.rv_public_comment)
    RecyclerView rvPublicComment;

    private MineAdapter adapter;
    private List<Mine> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_public_comment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init(){
        for (int i = 0; i < 3; i++) {
            list.add(new Mine());
        }
        rvPublicComment.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new MineAdapter(context, null);
        rvPublicComment.setAdapter(adapter);
        adapter.updateData(list);
    }
}
