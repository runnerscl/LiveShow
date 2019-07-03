package com.multi.liveshow.liveshow.entity;

import android.widget.LinearLayout;

import java.util.List;

public class BannerData {

    private List<Integer> imageList;//图片地址

    private List<String> titleList;//图片title

    public BannerData(List<Integer> imageList, List<String> titleList) {
        this.imageList = imageList;
        this.titleList = titleList;
    }

    public List<String> getTitleList() {
        return titleList;
    }

    public List<Integer> getImageList() {

        return imageList;
    }
}
