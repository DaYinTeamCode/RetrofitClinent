package com.goyin.mvp.utils;

import com.zhuoke.team.utils.BaseParamsMapUtil;

import java.util.Map;

/**
 * 作者：${User}
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：
 * 类描述：
 * 修改时间：${DATA}1530
 */

public class ParamsMapUtils  extends BaseParamsMapUtil{
    private static Map<String, String> mapparam;

    /**
     * 默认参数
     *
     * @return
     */
    public static Map<String, String> getDefaultParams() {
        return getParamsMap();
    }

    /**
     *   名称获取分类
     * @param name
     * @return
     */
    public static Map<String, String> getColumnDatail(String name) {
        mapparam = getDefaultParams();
        mapparam.put("shortName", name);
        return mapparam;
    }


    /**
     *   全部直播
     * @param offset
     * @param limit
     * @return
     */
    public static Map<String, String> getAlllLive(String offset,String limit) {
        mapparam = getDefaultParams();
        mapparam.put("offset", offset);
        mapparam.put("limit", limit);
        return mapparam;
    }

    /**
     *   登录
     * @param username
     * @param password
     * @return
     */
    public static Map<String, String> getlogin(String username,String password) {
        mapparam = getDefaultParams();
        mapparam.put("username", username);
        mapparam.put("password", password);
        return mapparam;
    }


}
