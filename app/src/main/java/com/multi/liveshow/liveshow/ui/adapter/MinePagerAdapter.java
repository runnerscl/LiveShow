package com.multi.liveshow.liveshow.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;


public class MinePagerAdapter extends FragmentPagerAdapter {

    private String[] title;
    private List<Fragment> list;


    public MinePagerAdapter(FragmentManager fm, String[] title, List<Fragment> list) {
        super(fm);
        this.title = title;
        this.list = list;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      //super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
