package com.boyacx.frameworkapp.network.netutils;

/**
 * Created by littleZ on 2018/3/27.
 */
public interface OnSuccessAndFaultListener {
    void onSuccess(String result);

    void onFault(String errorMsg);
}
