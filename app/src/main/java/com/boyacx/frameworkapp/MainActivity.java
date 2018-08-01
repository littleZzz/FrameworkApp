package com.boyacx.frameworkapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.boyacx.frameworkapp.network.netsubscribe.LoginSubscribe;
import com.boyacx.frameworkapp.network.netutils.OnSuccessAndFaultListener;
import com.boyacx.frameworkapp.network.netutils.OnSuccessAndFaultSub;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private Context mContext = this;
    @BindView(R.id.btn_click)
    Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_click})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_click:
                Toast.makeText(this, "按钮点击", Toast.LENGTH_SHORT).show();
                LoginSubscribe.login(new OnSuccessAndFaultSub(new OnSuccessAndFaultListener() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("收到的请求返回：", result);
                        Toast.makeText(mContext, "收到的请求返回：" + result, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFault(String errorMsg) {
                        Log.e("收到的请求返回error：", errorMsg);

                    }
                }));
                break;
        }

    }

}
