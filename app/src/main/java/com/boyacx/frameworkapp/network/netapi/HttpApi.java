package com.boyacx.frameworkapp.network.netapi;


import com.boyacx.frameworkapp.bean.QuestBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by littleZ on 2018/3/27.
 * <p>
 * 存放所有的Api
 */

public interface HttpApi {
    //请填写自己的接口名
    @POST("/bycx-passport-service/aSysLogin/cust/login")
    Observable<ResponseBody> getDataForBean(@Body QuestBean bean);

    //请填写自己的接口名
    @GET("")
    Observable<Response> getDataForMap(@QueryMap Map<String, Integer> map);

    /**
     * 通过地址下载一个文件
     */
    @GET()
    @Streaming
    Call<ResponseBody> downloadFile(@Url String fileUrl);

}
