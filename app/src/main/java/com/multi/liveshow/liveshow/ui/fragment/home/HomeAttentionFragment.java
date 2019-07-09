//package com.hotbitmapgg.bilibili.module.home.attention;
package com.multi.liveshow.liveshow.ui.fragment.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import com.multi.liveshow.liveshow.network.api.BiliApiService;

import com.multi.liveshow.liveshow.ui.adapter.AttentionDynamicAdapter;
import com.multi.liveshow.liveshow.base.RxLazyFragment;
import com.multi.liveshow.liveshow.entity.AttentionDynamicInfo;
import com.multi.liveshow.liveshow.network.RetrofitHelper;
import com.multi.liveshow.liveshow.utils.SnackbarUtil;
import com.multi.liveshow.liveshow.widget.CustomEmptyView;
import com.multi.liveshow.liveshow.presenter.NewsListPresenter;
import com.multi.liveshow.liveshow.presenter.view.lNewsListView;
import com.multi.liveshow.liveshow.base.BaseFragment;
import com.multi.liveshow.R;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;
import com.socks.library.KLog;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/22 21:40
 * 100332338@qq.com
 * <p/><NewsListPresenter>
 * 主界面关注界面
 */
public class HomeAttentionFragment extends RxLazyFragment<NewsListPresenter> implements lNewsListView  {
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty_layout)
    CustomEmptyView mCustomEmptyView;
    @BindView(R.id.layout_top)
    RelativeLayout topLayout;

    private boolean mIsRefreshing = false;

    //private val mPresenter by lazy{ VideoDetailPresenter()}
    private List<AttentionDynamicInfo.DataBean.FeedsBean> dynamics = new ArrayList<>();

    public static HomeAttentionFragment newInstance() {
        return new HomeAttentionFragment();
    }

    @Override
    protected NewsListPresenter createPresenter() {
        return new NewsListPresenter(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_attention;
    }

    @Override
    public void finishCreateView(Bundle state) {
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        initRefreshLayout();
        isPrepared = false;
    }

    @Override
    public void onError() {
        KLog.d("initRefreshLayout onerror" );
    }

    @Override
    public void onGetNewsListSuccess(List<AttentionDynamicInfo.DataBean.FeedsBean> newList) {
        KLog.d("onGetNewsListSuccess success" );
        initRecyclerView();
    }

    @Override
    protected void initRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
       /* mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
            mSwipeRefreshLayout.setRefreshing(true);
            mIsRefreshing = true;
            loadData();
        });*/
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mSwipeRefreshLayout.setRefreshing(true);
                KLog.d(" initRefreshLayout" );
                //clearData();
               //loadData();
                mPresenter.getNewsList();

            }

        });
    }


    @Override
    protected void finishTask() {
        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefreshing = false;
        hideEmptyView();
        initRecyclerView();
    }

    @Override
    protected void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AttentionDynamicAdapter mAdapter = new AttentionDynamicAdapter(mRecyclerView, dynamics);
        mRecyclerView.setAdapter(mAdapter);
        setRecycleNoScroll();
    }


    public void initEmptyView() {
        topLayout.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
        mCustomEmptyView.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_load_error);
        mCustomEmptyView.setEmptyText("加载失败~(≧▽≦)~啦啦啦.");
        SnackbarUtil.showMessage(mRecyclerView, "数据加载失败,请重新加载或者检查网络是否链接");
    }

    public void hideEmptyView() {
        topLayout.setVisibility(View.VISIBLE);
        mCustomEmptyView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void clearData() {
        mIsRefreshing = true;
        dynamics.clear();
    }

    private void setRecycleNoScroll() {
     //   mRecyclerView.setOnTouchListener((v, event) -> mIsRefreshing);
    }
}
