package com.goyin.mvp.presenter.home.interfaces;

import com.goyin.mvp.model.annotation.Implement;
import com.goyin.mvp.presenter.home.impl.HomePresenterImp;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/14 下午3:29
 **/
@Implement(HomePresenterImp.class)
public interface HomeContract {

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
      interface Presenter{

          /**
           *  提示消息
           */
          void message(String msg);


      }
}
