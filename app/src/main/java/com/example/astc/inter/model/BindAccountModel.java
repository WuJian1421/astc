package com.example.astc.inter.model;

import android.util.Log;

import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.BindAccountContract;
import com.example.astc.util.AppUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * BindAccountActivity Model
 * 2020-01-19
 *
 * @author
 */
public class BindAccountModel implements BindAccountContract.Model {
    private BindAccountContract.Presenter presenter;

    public BindAccountModel(BindAccountContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * 获取数据
     *
     * @param call
     * @param onRetrofits
     */
    @Override
    public void getCall(Call call, OnRetrofits onRetrofits) {
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("TAG", "----->" + "请求:" + response.raw());
                if (AppUtil.isObject(response.body())) {
                    Log.d("TAG", "----->" + "返回数据：" + response.body());
                    presenter.getData(response.body());
                    onRetrofits.onSuccess();
                } else {
                    onRetrofits.onFailure();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
                onRetrofits.onFailure();
            }
        });
    }
}
