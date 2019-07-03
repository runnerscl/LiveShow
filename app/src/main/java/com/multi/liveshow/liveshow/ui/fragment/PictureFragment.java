package com.multi.liveshow.liveshow.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.multi.liveshow.R;
import com.multi.liveshow.data.CommunityData;
import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.liveshow.ui.adapter.CommunityAdapter;
import com.multi.liveshow.liveshow.ui.adapter.PicAdapter;
import com.multi.liveshow.framework.ui.fragment.BaseFragment;
import com.multi.liveshow.framework.widget.TopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class PictureFragment extends BaseFragment {

    @BindView(R.id.topView)
    TopView topView;
    @BindView(R.id.rvPic)
    RecyclerView rvPic;

    private PicAdapter picAdapter;
    private List<Community> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_picture;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topView.setTitle("美图");
        topView.setLeftVisb(false);

        initRecycleView();
    }


    private void initRecycleView() {
        List<String> desList = CommunityData.getDesList();
        List<String> longDesList = CommunityData.getLongDesList();
        List<String> nickList = CommunityData.getNickList();
        List<Integer> headList = CommunityData.getHeadList();
        List<List<Integer>> lists = CommunityData.getLists();

        list.clear();
        for (int i = 0; i < desList.size(); i++) {
            list.add(new Community(nickList.get(i), desList.get(i), headList.get(i), lists.get(i), longDesList.get(i)));
        }
        rvPic.setLayoutManager(new GridLayoutManager(context, 1));
        picAdapter = new PicAdapter(context, null);
        rvPic.setAdapter(picAdapter);
        picAdapter.updateData(list);
    }
}
