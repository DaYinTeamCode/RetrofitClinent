package com.zhuoke.team.net.request;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/23 上午12:28
 **/
public interface BaseServiceApi {

    /**
     *    get  网络请求
     * @param url
     * @param maps
     * @return
     */
    @GET("{url}")
    Observable get(
            @Path("url") String url,
            @QueryMap Map<String, String> maps
    );

}
