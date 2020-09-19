package com.example.astc.inter.model;

import android.util.Log;

import com.example.astc.base.Applications;
import com.example.astc.bean.GetIDCardBean;
import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.IndividualCertificationContract;
import com.hjq.toast.ToastUtils;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IndividualCertificationActivity Model
 * <p>
 * 2020-01-19
 *
 * @author
 */
public class IndividualCertificationModel implements IndividualCertificationContract.Model {
    private IndividualCertificationContract.Presenter presenter;

    public IndividualCertificationModel(IndividualCertificationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * 查询认证状态
     *
     * @param jsonbObject
     * @param onRetrofits
     */
    @Override
    public void getCall(JSONObject jsonbObject, OnRetrofits onRetrofits) {
        Applications.getBasisProtocol().getIDCard(jsonbObject.toString())
                .enqueue(new Callback<GetIDCardBean>() {
                    @Override
                    public void onResponse(Call<GetIDCardBean> call, Response<GetIDCardBean> response) {
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
                    public void onFailure(Call<GetIDCardBean> call, Throwable t) {
                        t.printStackTrace();
                        onRetrofits.onFailure();
                    }
                });
    }

    /**
     * 提交认证资料
     *
     * @param jsonbObject
     * @param onRetrofits
     */
    @Override
    public void getSubmitCall(JSONObject jsonbObject, OnRetrofits onRetrofits) {

    }
}
