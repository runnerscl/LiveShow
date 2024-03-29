package com.multi.liveshow.liveshow.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.multi.liveshow.R;
import com.multi.liveshow.liveshow.base.AppConst;
import com.multi.liveshow.liveshow.entity.Community;
import com.multi.liveshow.liveshow.widget.ViewPagerBinner;
import com.multi.liveshow.framework.ui.activity.BaseActivity;
import com.multi.liveshow.framework.widget.TopView;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 美图的详情页面
 *
 * @author Danny_chen
 * @Date 2019/1/10
 * @package com.multi.liveshow.liveshow.ui.activity
 * @Desciption
 */
public class PicDetailActivity extends BaseActivity {

    @BindView(R.id.topView)
    TopView topView;
    @BindView(R.id.viewPager_banner)
    ViewPagerBinner viewPagerBinner;

    @BindView(R.id.cv_head)
    CircleImageView cvHead;
    @BindView(R.id.tv_nickName)
    TextView tvNickName;

    //传递过来的美图数据
    private Community community;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pic_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        community = (Community) getIntent().getSerializableExtra(AppConst.KEY_2);
        setUiData();
//        topView.setBackground(Color.TRANSPARENT);
//        topView.setLeftIcon(R.mipmap.back_white);
    }

    /**
     * 设置ui数据
     *
     * @param ,
     * @return void
     * @date 2019-06-10
     */
    private void setUiData() {
        if (community != null) {
            List<Integer> imageList = community.getImageList();
            if (imageList.size() == 2) {
                imageList.addAll(community.getImageList());
            } else if (imageList.size() == 1) {
                imageList.addAll(community.getImageList());
                imageList.addAll(community.getImageList());
            }
            viewPagerBinner.setImages(community.getImageList(), context);
            cvHead.setImageResource(community.getHead());
            tvNickName.setText(community.getNick());
            topView.setTitle(community.getNick());
        }
    }
}
