package com.example.astc.inter.model;

import android.util.Log;

import com.example.astc.R;
import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.BaseContract;
import com.example.astc.util.AppUtil;
import com.hjq.toast.ToastUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 公共MVP Model
 * 2019-12-22
 *
 * @author
 */
public class BaseModel implements BaseContract.Model {

    private BaseContract.Presenter presenter;

    public BaseModel(BaseContract.Presenter presenter) {
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
                    ToastUtils.show(response.message());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
                onRetrofits.onFailure();
                ToastUtils.show(R.string.loading_error);
            }
        });
    }
}
