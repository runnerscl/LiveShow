package com.multi.liveshow.framework.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.multi.liveshow.R;



public class ToastUtil {
    //上一次显示的信息
    private static String oldMsg;

    private static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    /**
     * 取消toast.
     * @return void
     **/
    public static void cancelToast(){
        if (toast!=null){
            toast.cancel();
            toast=null;
            oldMsg=null;
            oneTime = 0;
            twoTime = 0;
        }
    }


    public static void show(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (text.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = text;
                toast.setText(text);
                toast.show();
            }
        }
        oneTime = twoTime;
    }



    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }



    //////////////////////////////////////////////////////////////////
    //自定义样式
    /////////////////////////////////////////////////////////////////

    private static Toast customToast = null;
    /**
     * 无图标
     **/
    private static final int IMAGE_RESID_NONE=-1;//


    public static void customToast(Context context, String msg){
        customToast(context,msg,IMAGE_RESID_NONE);
    }


    public static void customToast(Context context, String msg, int imageResId){
        Context applicationContext=context.getApplicationContext();

        View vContent= LayoutInflater.from(applicationContext).inflate(R.layout.framework_layout_custom_toast,null);

        TextView tvMsg=vContent.findViewById(R.id.tv_message);
        tvMsg.setText(msg);
        if (IMAGE_RESID_NONE!=imageResId){
            ImageView ivIcon=vContent.findViewById(R.id.iv_icon);
            ivIcon.setImageResource(imageResId);
        }

        customToast(context,vContent);
    }


    public static void customToast(Context applicationContext, View view){
        applicationContext=applicationContext.getApplicationContext();
        if (customToast == null) {
            customToast = new Toast(applicationContext);
        }
        //设置toast居中显示
        customToast.setGravity(Gravity.CENTER, 0, 0);
        customToast.setDuration(Toast.LENGTH_SHORT);
        customToast.setView(view);
        customToast.show();
    }

    /**
     * 取消自定义toast
     * @return void
     **/
    public static void cancelCustomToast(){
        if (null!=customToast){
            customToast.cancel();
            customToast=null;
        }
    }
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //自定义样式
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
}
