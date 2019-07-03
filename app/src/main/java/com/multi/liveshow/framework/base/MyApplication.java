package com.multi.liveshow.framework.base;

import android.support.multidex.MultiDexApplication;

/**
 * @author Danny_chen
 * @Date 2019/06/11
 * @package com.multi.liveshow.framework.base;
 * @Desciption

 * #####################################################
 */
public class MyApplication extends MultiDexApplication {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 获取全局的上下文
     *
     * @return MyApplication
     * @date 2019-06-11
     */
    public static MyApplication getInstance() {
        return instance;
    }
}
