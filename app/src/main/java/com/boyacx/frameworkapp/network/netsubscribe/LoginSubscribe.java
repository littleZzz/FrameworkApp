package com.boyacx.frameworkapp.network.netsubscribe;


import com.boyacx.frameworkapp.bean.QuestBean;
import com.boyacx.frameworkapp.network.netutils.HttpMethods;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by littleZ on 2018/3/27.
 * 建议：把功能模块来分别存放不同的请求方法，比如登录注册类LoginSubscribe、电影类MovieSubscribe
 */

public class LoginSubscribe {
    /**
     * 获取数据
     */
    public static void login(DisposableObserver<ResponseBody> subscriber) {

        QuestBean questBean = new QuestBean();
        QuestBean.ParamsBean paramsBean = new QuestBean.ParamsBean();
        paramsBean.setLoginNo("15756281581");
        paramsBean.setPassword("123456");
        paramsBean.setLoginType("24200004");
        paramsBean.setApplyType("25800002");
        paramsBean.setSourceOsType("30500001");
        questBean.setParams(paramsBean);
        Observable<ResponseBody> observable = HttpMethods.getInstance().getHttpApi().getDataForBean(questBean);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }
}
