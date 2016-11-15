package com.goyin.mvp.presenter.login.interfaces;

import com.goyin.mvp.base.CommonPresenter;
import com.goyin.mvp.base.CommonView;
import com.goyin.mvp.model.annotation.Implement;
import com.goyin.mvp.presenter.home.impl.HomePresenterImp;
import com.goyin.mvp.presenter.login.impl.LoginPresenterImp;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：   登录业务逻辑和更新UI接口
 *  备注消息：
 *  修改时间：2016/11/9 上午11:15
 **/
@Implement(LoginPresenterImp.class)
public interface LoginContract {

    /**
     *   View :
     *       activity|fragment  implements
     *
     *     登录页面更新UI相关操作
     */
   interface View extends CommonView{

        /**
         * 页面跳转
         */
        void startAct(Class<?> cls, boolean finish);

    }
    /**
     *   presenter
     *
     */
   interface Presenter extends CommonPresenter{

        /**
         *   账号登录
         * @param tel 账号
         * @param pwd 密码
         */
        void login(String tel,String pwd);

        /**
         *  用户注册
         */
        void regist();

        /**
         *  忘记密码
         */
        void forgetPwd();


    }


}
