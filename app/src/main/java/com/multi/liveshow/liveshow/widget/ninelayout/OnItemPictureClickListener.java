package com.multi.liveshow.liveshow.widget.ninelayout;

import android.widget.ImageView;

import java.util.List;

public interface OnItemPictureClickListener {
    void onItemPictureClick(int itemPosition, int i, int url, List<Integer> urlList, ImageView imageView);
}
