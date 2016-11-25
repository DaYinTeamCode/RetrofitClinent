package com.goyin.mvp.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.goyin.mvp.api.NetWorkApi;
import com.zhuoke.team.net.config.NetWorkConfiguration;
import com.zhuoke.team.net.http.HttpUtils;

import java.util.Set;


/**
 * 作者：gaoyin
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：2.0
 * 类描述： 全局初始化Appliation
 * 备注消息：
 * 修改时间：16/8/18 上午11:48
 **/
public class ShopAppLication extends Application {

    private Set<Activity> allActivities;
    public static ShopAppLication mContext;

    public static synchronized ShopAppLication getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //设置缓存路径
        mContext = this;
        configuration();
    }
    private void configuration() {
        NetWorkConfiguration configuration=new NetWorkConfiguration(this)
                                                                .baseUrl(NetWorkApi.baseUrl)
                                                                .isCache(true)
                                                                .isDiskCache(true)
                                                                .isMemoryCache(false);
        HttpUtils.setConFiguration(configuration);
    }

    public static Context getContext() {
        return mContext;
    }
}
