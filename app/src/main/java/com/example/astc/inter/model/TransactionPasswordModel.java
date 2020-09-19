package com.example.astc.inter.model;

import android.util.Log;

import com.example.astc.base.Applications;
import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.TransactionPasswordContract;
import com.hjq.toast.ToastUtils;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * TransactionPasswordActivity Model
 * 2020-01-16
 *
 * @author
 */
public class TransactionPasswordModel implements TransactionPasswordContract.Model {
    private TransactionPasswordContract.Presenter presenter;

    public TransactionPasswordModel(TransactionPasswordContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * 获取助记词
     *
     * @param jsonbObject
     * @param onRetrofits
     */
    @Override
    public void getCall(JSONObject jsonbObject, OnRetrofits onRetrofits) {
        Applications.getBasisProtocol().getMemoByUserName(jsonbObject.toString())
                .enqueue(new Callback<GetMemoByUserNameBean>() {
                    @Override
                    public void onResponse(Call<GetMemoByUserNameBean> call, Response<GetMemoByUserNameBean> response) {
                        Log.d("TAG", "----->" + "请求:" + response.raw());
                        Log.d("TAG", "----->" + "返回数据：" + response.body());
                        if (response.body().getCode() == Applications.NetworkingCode) {
                            presenter.getData(response.body());
                            onRetrofits.onSuccess();
                        } else {
                            ToastUtils.show(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<GetMemoByUserNameBean> call, Throwable t) {
                        t.printStackTrace();
                        onRetrofits.onFailure();
                    }
                });
    }

    /**
     * 设置/修改交易密码
     *
     * @param jsonbObject
     * @param onRetrofits
     */
    @Override
    public void getPassword(JSONObject jsonbObject, OnRetrofits onRetrofits) {
        Applications.getBasisProtocol().editDealPwd(jsonbObject.toString())
                .enqueue(new Callback<BaseBean>() {
                    @Override
                    public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                        Log.d("TAG", "----->" + "请求:" + response.raw());
                        Log.d("TAG", "----->" + "返回数据：" + response.body());
                        if (response.body().getCode() == Applications.NetworkingCode) {
                            presenter.getSubmitData(response.body());
                            onRetrofits.onSuccess();
                        } else {
                            onRetrofits.onFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseBean> call, Throwable t) {
                        t.printStackTrace();
                        onRetrofits.onFailure();
                    }
                });
    }
}
