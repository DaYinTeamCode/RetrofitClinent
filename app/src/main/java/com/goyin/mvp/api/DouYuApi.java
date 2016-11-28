package com.goyin.mvp.api;

import com.goyin.mvp.model.home.ColumnDetail;
import com.goyin.mvp.model.live.LiveList;
import com.goyin.mvp.model.login.UserInfo;
import com.zhuoke.team.net.response.HttpResponse;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者：${User}
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：
 * 类描述：
 * 修改时间：${DATA}1453
 */

public interface DouYuApi {

    @GET(NetWorkApi.getColumnDetail)
    Observable<HttpResponse<List<ColumnDetail>>> getColumnDetail(@QueryMap Map<String, String> maps);

    @GET(NetWorkApi.getAllLive)
    Observable<HttpResponse<List<LiveList>>> getAllLive(@QueryMap Map<String, String> maps);

    /**
     *  登录
     * @param maps
     * @return
     */
    @GET(NetWorkApi.getLogin)
    Observable<HttpResponse<UserInfo>> getLogin(@QueryMap Map<String, String> maps);
}
