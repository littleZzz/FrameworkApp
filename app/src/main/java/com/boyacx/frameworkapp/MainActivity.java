package com.boyacx.frameworkapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.boyacx.frameworkapp.network.netsubscribe.LoginSubscribe;
import com.boyacx.frameworkapp.network.netutils.OnSuccessAndFaultListener;
import com.boyacx.frameworkapp.network.netutils.OnSuccessAndFaultSub;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private Context mContext = this;
    @BindView(R.id.btn_click)
    Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_click, R.id.btn_permission})
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
                }, mContext));
                break;
            case R.id.btn_permission:



                String[] perStr = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
                if (!checkPermission(MainActivity.this, perStr)) {
                    requestPermission(MainActivity.this, "请给我权限", 1, perStr);
                }

                break;


        }
    }


    /**
     * @param context return true:已经获取权限
     *                return false: 未获取权限，主动请求权限
     */

    public static boolean checkPermission(Activity context, String[] perms) {
        return EasyPermissions.hasPermissions(context, perms);
    }

    /**
     * 请求权限
     *
     * @param context
     */
    public static void requestPermission(Activity context, String tip, int requestCode, String[] perms) {
        EasyPermissions.requestPermissions(context, tip, requestCode, perms);
    }

    /**
     * 重写onRequestPermissionsResult，用于接受请求结果
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将请求结果传递EasyPermission库处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    /**
     * 请求权限成功。
     * 可以弹窗显示结果，也可执行具体需要的逻辑操作
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Toast.makeText(getApplicationContext(), "用户授权成功", Toast.LENGTH_SHORT).show();
    }

    /**
     * 请求权限失败
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(getApplicationContext(), "用户授权失败", Toast.LENGTH_SHORT).show();
        /**
         * 若是在权限弹窗中，用户勾选了'NEVER ASK AGAIN.'或者'不在提示'，且拒绝权限。
         * 这时候，需要跳转到设置界面去，让用户手动开启。
         */
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }


}
