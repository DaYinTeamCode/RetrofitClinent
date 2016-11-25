package com.goyin.mvp.api;

import com.goyin.mvp.model.home.ColumnDetail;
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
}
