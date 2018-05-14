package com.example.dell.univstarproject.base;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class BaseApp extends Application {
    public static BaseActivity activity;
    public static AppCompatActivity content;

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }
}


