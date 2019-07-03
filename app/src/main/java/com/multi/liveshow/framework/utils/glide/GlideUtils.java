package com.multi.liveshow.framework.utils.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.multi.liveshow.framework.utils.LogUtils;

import java.io.File;



public class GlideUtils {

    private static final String TAG = GlideUtils.class.getSimpleName();


    public static void show(Context context, Object url, ImageView imageView) {
        show(context, url, imageView, -1, -1, 1.0f, false, DiskCacheStrategy.ALL);
    }


    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId) {
        show(context, url, imageView, placeResId, errorResId, 1.0f, false, DiskCacheStrategy.ALL);
    }


    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId, float sizeMultiplier) {
        show(context, url, imageView, placeResId, errorResId, sizeMultiplier, false, DiskCacheStrategy.ALL);
    }


    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId, float sizeMultiplier, boolean skipMemoryCache) {
        show(context, url, imageView, placeResId, errorResId, sizeMultiplier, skipMemoryCache, DiskCacheStrategy.ALL);
    }


    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId, float sizeMultiplier, boolean skipMemoryCache,
                            DiskCacheStrategy diskCacheStrategy) {
        Glide.with(context)
                .load(url)
                .placeholder(placeResId)//
                .error(errorResId)//
                .thumbnail(sizeMultiplier)
                .skipMemoryCache(skipMemoryCache)//是否跳过内存缓存
                .diskCacheStrategy(diskCacheStrategy)//是否使用磁盘缓存
                .into(imageView);
    }



    public static void showCutedImage(Context context, String url, ImageView imageView, int width, int height) {
        showCutedImage(context, url, imageView, width, height, -1, -1);
    }


    public static void showCutedImage(Context context, String url, ImageView imageView, int width, int height,
                                      int placeResId, int errorResId) {
        Glide.with(context)
                .load(url)
                .override(width, height)//这里的单位是px
                .placeholder(placeResId)
                .error(errorResId)
                .into(imageView);
    }



    public static void loadBitmap(Context context, String url, SimpleTarget<Bitmap> target) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .into(target);
    }


    public static void showRoundImage(Context context, Object url, ImageView imageView, float radius) {
        showRoundImage(context, url, imageView, radius, -1, -1);

    }



    public static void showRoundImage(Context context, Object url, ImageView imageView, float radius, int placeResId, int errorResId) {

        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(placeResId)
                .error(errorResId)
                .skipMemoryCache(true)//是否跳过内存缓存
                .transform(new RoundTransformation(context, radius))
                .diskCacheStrategy(DiskCacheStrategy.ALL)//是否使用磁盘缓存
                .into(imageView);

    }


    public static void loadLocal(Context context, String strFile, ImageView imageView) {
        loadLocal(context, strFile, imageView, 0);
    }


    public static void loadLocal(Context context, String filePath, ImageView imageView, float radius) {
        File file = new File(filePath);
        if (!file.exists()) {
            LogUtils.w(TAG, "loadLocal() ," + filePath + " 文件不存在！");
            return;
        }
        if (!file.isFile()) {
            LogUtils.w(TAG, "loadLocal() ," + filePath + " 不是文件！");
            return;
        }
        loadLocal(context, file, imageView, radius);
    }


    public static void loadLocal(Context context, File file, ImageView imageView) {
        loadLocal(context, file, imageView, 0, -1, -1);
    }


    public static void loadLocal(Context context, File file, ImageView imageView, float radius) {
        loadLocal(context, file, imageView, radius, -1, -1);
    }


    public static void loadLocal(Context context, File file, ImageView imageView, float radius, int placeResId, int errorResId) {
        Glide.with(context)
                .load(file)
                .placeholder(placeResId)
                .error(errorResId)
                .transform(new RoundTransformation(context, radius))
                .into(imageView);
    }


}
