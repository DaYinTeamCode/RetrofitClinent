package com.zhuoke.team.utils;

import android.util.Log;

/**
 * 作者：gaoyin
 *
 * 邮箱:18810474975@163.com
 *
 * 日期：2016/2/24
 *
 * 描述信息：  打印在控制台的BUG工具类
 *
 * 备注信息:
 */
public class L {

//  True为显示BUG信息，False为关闭BUG信息
    public static boolean DEBUG = false;
//  默认过滤当前项目的包名称
    private static String Tag = "Retrofit";
//  私有化构造
    private L()
    {
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    /**
     *   过滤Error信息
     * @param msg  信息体
     */
    public static void e(String msg)
    {
        if (DEBUG)
        {
            Log.e(Tag, msg);
        }
    }

    public static void e(String Tag,String msg)
    {
         if(DEBUG)
         {
             Log.e(Tag, msg);
         }
    }

    /**
     *  过滤info信息
     * @param msg  信息体
     */
    public static void i(String msg)
    {
        if(DEBUG)
        {
            Log.i(Tag, msg);
        }
    }

    /**
     *  过滤verbose信息
     * @param msg
     */
    public static void v(String msg)
    {
         if(DEBUG)
         {
             Log.v(Tag, msg);
         }
    }

    /**
     *  过滤DEBUG信息
     * @param msg
     */
    public static void d(String msg)
    {
          if(DEBUG)
          {
              Log.d(Tag, msg);
          }
    }

    /**
     *  自定义TAG函数
     */
    /**
     *  过滤info信息
     * @param TAG
     * @param msg
     */
    public static void i(String TAG,String msg)
    {
         if(DEBUG)
         {
              Log.i(TAG, msg);
         }
    }

    /**
     *  过滤DEBUG信息
     * @param TAG
     * @param msg
     */
    public static void d(String TAG,String msg)
    {
        if(DEBUG)
        {
            Log.d(TAG, msg);
        }
    }
    /**
     *  过滤verbose信息
     * @param TAG
     * @param msg
     */
    public static void v(String TAG,String msg)
    {
        if(DEBUG)
        {
            Log.v(TAG, msg);
        }
    }


}

