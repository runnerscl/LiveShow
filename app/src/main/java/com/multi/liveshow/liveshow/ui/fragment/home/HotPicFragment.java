package com.multi.liveshow.liveshow.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.multi.liveshow.R;
import com.multi.liveshow.data.CommunityData;
import com.multi.liveshow.data.HotPicData;
import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.liveshow.entity.HotPic;
import com.multi.liveshow.liveshow.ui.adapter.home.HotPicAdapter;
import com.multi.liveshow.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * 首页热门的fragment
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class HotPicFragment extends BaseFragment {

    @BindView(R.id.rv_hot_pic)
    RecyclerView rvHotPic;

    private HotPicAdapter hotPicAdapter;

    private List<HotPic> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragmnet_hot_pic;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecycleView();
    }

    private void initRecycleView() {

        List<Integer> headList = HotPicData.getHeadList();
        List<String> nickList = HotPicData.getNickList();
        List<Integer> imageList = HotPicData.getImagList();

        list.clear();
        for (int i = 0; i < nickList.size(); i++) {
            list.add(new HotPic(imageList.get(i), headList.get(i), nickList.get(i), i));
        }

        rvHotPic.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        hotPicAdapter = new HotPicAdapter(context, null);
        rvHotPic.setAdapter(hotPicAdapter);

        hotPicAdapter.updateData(list);
    }
}
