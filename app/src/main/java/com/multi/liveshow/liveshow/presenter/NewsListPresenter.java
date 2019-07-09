package com.multi.liveshow.liveshow.presenter;

import com.multi.liveshow.liveshow.entity.AttentionDynamicInfo;
//import com.chaychan.news.model.entity.NewsData;
//import com.chaychan.news.model.response.NewsResponse;
import com.multi.liveshow.liveshow.base.BasePresenter;
//import com.chaychan.news.utils.ListUtils;
//import com.chaychan.news.utils.PreUtils;
import com.multi.liveshow.liveshow.presenter.view.lNewsListView;
import com.google.gson.Gson;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * @author ChayChan
 * @description: 新闻列表的presenter
 * @date 2017/6/18  10:04
 */

public class NewsListPresenter extends BasePresenter<lNewsListView> {

    private long lastTime;
    private List<AttentionDynamicInfo.DataBean.FeedsBean> dynamics = new ArrayList<>();

    public NewsListPresenter(lNewsListView view) {
        super(view);
    }


    public void getNewsList() {
        addSubscription(mApiService.getAttentionDynamic(), new Subscriber<AttentionDynamicInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                KLog.e(e.getLocalizedMessage());
                mView.onError();
            }

            @Override
            public void onNext(AttentionDynamicInfo response) {
                KLog.d(" fix AttentionDynamicInfo url: " );
               /* lastTime = System.currentTimeMillis() / 1000;
                PreUtils.putLong(channelCode,lastTime);//保存刷新的时间戳

                List<NewsData> data = response.data;
                KLog.d("chenglong NewListPresenter onNext data: " + data);
                List<News> newsList = new ArrayList<>();
                if (!ListUtils.isEmpty(data)){
                    for (NewsData newsData : data) {
                        News news = new Gson().fromJson(newsData.content, News.class);
                        newsList.add(news);
                    }
                }*/
                //.e(newsList);
                List<AttentionDynamicInfo.DataBean.FeedsBean> data = response.getData().getFeeds();

                dynamics.addAll(data);
                //List<AttentionDynamicInfo.DataBean.FeedsBean> newsList = new ArrayList<>();
                //for (AttentionDynamicInfo.DataBean.FeedsBean newsData: data) {
                //   AttentionDynamicInfo.DataBean.FeedsBean news = new Gson().fromJson(response.getData().getFeeds(), AttentionDynamicInfo.DataBean.FeedsBean.class);
                //    newsList.add(news);
               // }


                mView.onGetNewsListSuccess(dynamics);
            }
        });
    }
}
