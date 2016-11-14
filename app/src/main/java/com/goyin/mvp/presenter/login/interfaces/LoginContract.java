package com.goyin.mvp.presenter.login.interfaces;

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
   interface View{
        /**
         *  提示成功信息
         * @param msg
         */
        void showSuccessWithStatus(String msg);

        /**
         *  提示错误信息
         * @param msg
         */
        void showErrorWithStatus(String msg);

        /**
         *  提示消息
         * @param msg
         */
        void showsInfoWithStatus(String msg);
        /**
         *  进度框
         * @param msg
         */
        void showWithProgress(String msg);

        /**
         *
         */
        void dismiss();

    }
    /**
     *   presenter:
     *
     */
   interface Presenter{

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
