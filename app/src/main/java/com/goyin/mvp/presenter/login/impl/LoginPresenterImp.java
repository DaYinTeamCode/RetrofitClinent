package com.goyin.mvp.presenter.login.impl;

import android.os.Handler;
import android.os.Message;

import com.goyin.mvp.api.DouYuApi;
import com.goyin.mvp.base.BasePresenter;
import com.goyin.mvp.model.login.UserInfo;
import com.goyin.mvp.presenter.login.interfaces.LoginContract;
import com.goyin.mvp.utils.ParamsMapUtils;
import com.goyin.mvp.view.common.activity.MainActivity;
import com.goyin.mvp.view.login.LoginActivity;
import com.zhuoke.team.net.callback.RxSubscriber;
import com.zhuoke.team.net.exception.ResponeThrowable;
import com.zhuoke.team.net.http.HttpUtils;
import com.zhuoke.team.net.transformer.DefaultTransformer;
import com.zhuoke.team.utils.L;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/9 上午11:19
 **/
public class LoginPresenterImp extends BasePresenter<LoginActivity> implements LoginContract.Presenter {

    private static final int LOGIN_SUCCUSS=200;

    private static final int LOGIN_FAIL=500;

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what)
            {
                case LOGIN_SUCCUSS:
                    if(mView!=null) {
                        mView.dismiss();

                    }
                    break;
                case LOGIN_FAIL:
                    if(mView!=null) {
                        mView.dismiss();

                    }
                    break;
            }
        }
    };
    /**
     *  登录业务逻辑
     * @param tel 账号
     * @param pwd 密码
     */
    @Override
    public void login(final String tel, final String pwd) {
        /**
         *   针对数据就行校验
         *       项目中校验数据使用正则表达式
         *   这里进行简单校验
         */
        if(tel.isEmpty())
        {
            mView.showsInfoWithStatus("请填写账号!");
            return;

        }
        else if(pwd.isEmpty())
        {
            mView.showsInfoWithStatus("请填写密码!");
            return;
        }

          mView.showWithProgress("加载中...");
        HttpUtils.getInstance(mView.getApplicationContext())
                .setLoadDiskCache(false)
                .getRetofitClinet()
                .builder(DouYuApi.class)
                .getLogin(ParamsMapUtils.getlogin(tel,pwd))
                .compose(new DefaultTransformer<UserInfo>())
                .compose(mView.<UserInfo>bindToLifecycle())
                .subscribe(new RxSubscriber<UserInfo>() {
                    @Override
                    public void onSuccess(UserInfo userInfos) {
                        L.DEBUG = true;
                        L.e("数据为:" + userInfos.toString());
                        mView.showSuccessWithStatus("登录成功");
                        mView.startAct(MainActivity.class, true);

                    }
                    @Override
                    public void onError(ResponeThrowable e) {
                        super.onError(e);
                        mView.showErrorWithStatus("登录失败!");
                        L.DEBUG = true;
                        L.e("错误信息:" + e.message);
                    }
                });
    }
    @Override
    public void regist() {
       mView.showSuccessWithStatus("注册成功");

    }

    @Override
    public void forgetPwd() {
       mView.showSuccessWithStatus("忘记密码");
    }
}
