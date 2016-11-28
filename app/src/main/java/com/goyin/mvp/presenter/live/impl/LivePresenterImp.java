package com.goyin.mvp.presenter.live.impl;

import com.goyin.mvp.api.DouYuApi;
import com.goyin.mvp.base.BasePresenter;
import com.goyin.mvp.model.live.LiveList;
import com.goyin.mvp.presenter.live.interfaces.LiveContract;
import com.goyin.mvp.utils.ParamsMapUtils;
import com.goyin.mvp.view.common.fragment.LiveFragment;
import com.zhuoke.team.net.callback.RxSubscriber;
import com.zhuoke.team.net.exception.ResponeThrowable;
import com.zhuoke.team.net.http.HttpUtils;
import com.zhuoke.team.net.transformer.DefaultTransformer;
import com.zhuoke.team.utils.L;
import com.zhuoke.team.utils.RxUtils;

import java.util.List;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/14 下午3:22
 **/
public class LivePresenterImp extends BasePresenter<LiveFragment> implements LiveContract.Presenter {

    @Override
    public void message(String msg) {
        mView.showSuccessWithStatus(msg);
    }

    @Override
    public void allLiveList() {
        HttpUtils.getInstance(mView.getContext())
                .setLoadDiskCache(false)
                .setLoadMemoryCache(false)
                .getRetofitClinet()
                .builder(DouYuApi.class)
                .getAllLive(ParamsMapUtils.getAlllLive("0","20"))
//               进行预处理
                .compose(new DefaultTransformer<List<LiveList>>())
//               绑定当前activity或者fragment 与Observable 的生命周期
                .compose(mView.<List<LiveList>>bindToLifecycle())
//               线程进行切换
//                .compose(RxUtils.<List<LiveList>>rxSchedulerHelper())
                .subscribe(new RxSubscriber<List<LiveList>>() {
                    @Override
                    public void onSuccess(List<LiveList> columnDetails) {
                        L.DEBUG = true;
                        L.e("数据为:" + columnDetails.toString());
                    }
                    @Override
                    public void onError(ResponeThrowable e) {
                        L.DEBUG = true;
                        L.e("错误信息:" + e.message);
                    }
                });

}
}