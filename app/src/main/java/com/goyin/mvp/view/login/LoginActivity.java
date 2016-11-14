package com.goyin.mvp.view.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.gaoyin.mvp.R;
import com.goyin.mvp.base.BaseActivity;
import com.goyin.mvp.base.SwipeBackActivity;
import com.goyin.mvp.model.annotation.Implement;
import com.goyin.mvp.presenter.login.impl.LoginPresenterImp;
import com.goyin.mvp.presenter.login.interfaces.LoginContract;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * 作者：gaoyin
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 修改时间：2016/11/8 下午4:07
 **/

public class LoginActivity extends BaseActivity<LoginPresenterImp> implements LoginContract.View {

    public Context context;
    @Bind(R.id.qq)
    ImageView qq;
    @Bind(R.id.wb)
    ImageView wb;
    @Bind(R.id.wx)
    ImageView wx;
    @Bind(R.id.img_signed)
    ImageView imgSigned;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_ok)
    TextView tvOk;
    @Bind(R.id.img_msg)
    ImageView imgMsg;
    @Bind(R.id.et_loginTel)
    EditText etLoginTel;
    @Bind(R.id.et_loginPwd)
    EditText etLoginPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_regist)
    TextView tvRegist;
    @Bind(R.id.tv_forgetPwd)
    TextView tvForgetPwd;
    @Bind(R.id.top)
    AutoLinearLayout top;
    @Bind(R.id.activity_login)
    AutoRelativeLayout activityLogin;

    SVProgressHUD svProgressHUD;

    String tel, pwd;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        tvTitle.setText(getResources().getString(R.string.login));
        svProgressHUD = new SVProgressHUD(this);
        context=this;

    }
    @Override
    protected void onEvent() {


    }
//登录
    @OnClick(R.id.btn_login)
    public void login()
    {
        tel = etLoginTel.getText().toString();
        pwd = etLoginPwd.getText().toString();
        mPresenter.login(tel, pwd);
    }
//    注册
    @OnClick(R.id.tv_regist)
    public void regist()
    {
        mPresenter.regist();
    }

    //   忘记密码
    @OnClick(R.id.tv_forgetPwd)
    public void forgetPwd()
    {
       mPresenter.forgetPwd();
    }

    @Override
    protected Class getContractClazz() {
        return LoginContract.class;
    }

    @Override
    public void showSuccessWithStatus(String msg) {

        svProgressHUD.showSuccessWithStatus(msg);
    }

    @Override
    public void showErrorWithStatus(String msg) {
        svProgressHUD.showErrorWithStatus(msg);
    }

    @Override
    public void showsInfoWithStatus(String msg) {
       svProgressHUD.showInfoWithStatus(msg);
    }

    @Override
    public void showWithProgress(String msg) {
         svProgressHUD.showWithStatus(msg, SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
    }

    @Override
    public void dismiss() {
        svProgressHUD.dismiss();

    }
    @Override
    public void startAct(Class<?> cls, boolean finish) {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
        if(finish)
        {
            finish();
        }
    }
}
