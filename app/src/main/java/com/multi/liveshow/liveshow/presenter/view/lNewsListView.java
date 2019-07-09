package com.multi.liveshow.liveshow.presenter.view;

import com.multi.liveshow.liveshow.entity.AttentionDynamicInfo;

import java.util.List;

/**
 * @author ChayChan
 * @description: 获取各种频道广告的View回调接口
 * @date 2017/6/18  9:33
 */

public interface lNewsListView {

    void onGetNewsListSuccess(List<AttentionDynamicInfo.DataBean.FeedsBean> newList);

    void  onError();
}
