package com.multi.liveshow.framework.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;
import android.view.WindowManager;


import com.multi.liveshow.framework.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {

    protected String tag;
    protected Activity activity;
    protected Context context;

    private Unbinder unbinder;

    //有时候需要销毁多个activity，将任务栈中的activity保存在集合中
    private static List<Activity> listActivities = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏透明
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 设置状态栏字体黑色
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        tag = this.getClass().getSimpleName();
        context = this;
        activity = this;
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

        listActivities.add(this);
    }

    protected abstract int getLayoutId();

    @Override
    protected void onStart() {
        LogUtils.i(tag, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(tag, "onResume()");
    }

    @Override
    protected void onPause() {
        LogUtils.i(tag, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtils.i(tag, "onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        LogUtils.i(tag, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        LogUtils.i(tag, "onDestroy()");
        if (null != unbinder) {
            unbinder.unbind();
        }
        listActivities.remove(this);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        LogUtils.i(tag, "onBackPressed()");
        super.onBackPressed();
    }


    public static void existApp() {
        for (Activity activity : listActivities) {
            activity.finish();
        }
    }


    protected void finishActivity(Class clazz) {
        for (Activity activity : listActivities) {
            if (activity.getClass() == clazz) {
                activity.finish();
                break;
            }
        }
    }


    public void skipPage(Class<? extends Activity> cls) {
        Intent intent = new Intent(this, cls);
        //startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        startActivity(intent);
    }

}
