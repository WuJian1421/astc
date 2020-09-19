package com.example.astc.inter.model;

import android.util.Log;

import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.MnemonicContract;
import com.example.astc.util.AppUtil;
import com.hjq.toast.ToastUtils;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * MnemonicFragment Model
 * 2019-12-25
 *
 * @author
 */
public class MnemonicModel implements MnemonicContract.Model {

    private MnemonicContract.Presenter presenter;

    public MnemonicModel(MnemonicContract.Presenter mnemonicPresenter) {
        this.presenter = mnemonicPresenter;
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
                            onRetrofits.onFailure();
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
     * 助记词登录
     *
     * @param jsonbObject
     * @param onRetrofits
     */
    @Override
    public void getSubmitCall(JSONObject jsonbObject, OnRetrofits onRetrofits) {
        Applications.getBasisProtocol().memoLogin(RequestBody.create(AppUtil.getMediaType(), jsonbObject.toString()))
                .enqueue(new Callback<NewLoginBean>() {
                    @Override
                    public void onResponse(Call<NewLoginBean> call, Response<NewLoginBean> response) {
                        Log.d("TAG", "----->" + "请求:" + response.raw());
                        Log.d("TAG", "----->" + "返回数据：" + response.body());
                        if (response.body().getCode() == Applications.NetworkingCode) {
                            presenter.getSubmitData(response.body());
                            onRetrofits.onSuccess();
                        } else {
                            onRetrofits.onFailure();
                            ToastUtils.show(R.string.mnemonic_error);
                        }
                    }

                    @Override
                    public void onFailure(Call<NewLoginBean> call, Throwable t) {
                        t.printStackTrace();
                        onRetrofits.onFailure();
                    }
                });
    }
}
