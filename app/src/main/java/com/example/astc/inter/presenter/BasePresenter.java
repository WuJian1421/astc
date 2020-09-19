package com.example.astc.inter.presenter;

import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.BaseContract;
import com.example.astc.inter.model.BaseModel;

/**
 * 公共MVP Presenter
 * 2019-12-22
 *
 * @author
 */
public class BasePresenter implements BaseContract.Presenter, OnRetrofits {

    private BaseContract.View view;
    private BaseContract.Model model;

    public BasePresenter(BaseContract.View view) {
        this.view = view;
        model = new BaseModel(this);
    }

    /**
     * 成功
     */
    @Override
    public void onSuccess() {
        view.endLoading();
    }

    /**
     * 失败
     */
    @Override
    public void onFailure() {
        view.endLoading();
    }

    /**
     * 请求数据
     */
    @Override
    public void methodCall() {
        view.startLoading();
        model.getCall(view.setCall(), this);
    }

    /**
     * 返回数据
     *
     * @param o
     */
    @Override
    public void getData(Object o) {
        view.getData(o);
    }
}
