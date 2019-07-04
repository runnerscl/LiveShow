package com.multi.liveshow.liveshow.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.ui.adapter.MinePagerAdapter;
import com.multi.liveshow.liveshow.ui.fragment.home.CartoonFragment;
import com.multi.liveshow.liveshow.ui.fragment.home.EchelonFragment;
import com.multi.liveshow.liveshow.ui.fragment.home.HomeAttentionFragment;
import com.multi.liveshow.liveshow.ui.fragment.home.HotPicFragment;
import com.multi.liveshow.liveshow.ui.fragment.home.MusicFragment;
import com.multi.liveshow.liveshow.ui.fragment.home.RecommendFragment;
import com.multi.liveshow.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;


public class HomeFragment extends BaseFragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.xTablayout)
    XTabLayout tabLayout;

    //tableLayout的标题源数据
    private String[] mTitles = {"关注", "推荐", "热门", "卡通", "优图", "音乐"};
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }


    private void initViewPager() {
        HomeAttentionFragment fragment0 = new HomeAttentionFragment();
        RecommendFragment fragment1 = new RecommendFragment();
        HotPicFragment fragment2 = new HotPicFragment();
        CartoonFragment fragment3 = new CartoonFragment();
        EchelonFragment fragment4 = new EchelonFragment();
        MusicFragment fragment5 = new MusicFragment();

        list.add(fragment0);
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);

        MinePagerAdapter pagerAdapter = new MinePagerAdapter(
                Objects.requireNonNull(getActivity()).getSupportFragmentManager(), mTitles, list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
    }
}
