package com.goyin.mvp.presenter.home.impl;

import com.goyin.mvp.api.DouYuApi;
import com.goyin.mvp.base.BasePresenter;
import com.goyin.mvp.model.home.ColumnDetail;
import com.goyin.mvp.presenter.home.interfaces.HomeContract;
import com.goyin.mvp.utils.ParamsMapUtils;
import com.goyin.mvp.view.common.fragment.HomeFragment;
import com.zhuoke.team.net.callback.RxSubscriber;
import com.zhuoke.team.net.exception.ExceptionHandle;
import com.zhuoke.team.net.http.HttpUtils;
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
public class HomePresenterImp extends BasePresenter<HomeFragment> implements HomeContract.Presenter {

    @Override
    public void message(String msg) {
        mView.showSuccessWithStatus(msg);
    }

    @Override
    public void columnDetail() {
       HttpUtils.getInstance(mView.getContext())
                .setLoadDiskCache(true)
                .setLoadMemoryCache(false)
                .getRetofitClinet()
                .builder(DouYuApi.class)
                .getColumnDetail(ParamsMapUtils.getColumnDatail("game"))
//               进行预处理
                .compose(RxUtils.<List<ColumnDetail>>transformer())
//               绑定当前activity或者fragment 与Observable 的生命周期
                .compose(mView.<List<ColumnDetail>>bindToLifecycle())
//               线程进行切换
                .compose(RxUtils.<List<ColumnDetail>>rxSchedulerHelper())
                .subscribe(new RxSubscriber<List<ColumnDetail>>() {
                   @Override
                   public void onSuccess(List<ColumnDetail> columnDetails) {
                                               L.DEBUG = true;
                        L.e("数据为:" + columnDetails.toString());
                   }
                   @Override
                   public void onError(ExceptionHandle.ResponeThrowable e) {
                        L.DEBUG = true;
                        L.e("错误信息:" + e.message);
                   }
               });
    }


}
