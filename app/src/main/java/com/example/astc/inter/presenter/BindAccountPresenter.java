package com.example.astc.inter.presenter;

import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.BindAccountContract;
import com.example.astc.inter.model.BindAccountModel;

/**
 * BindAccountActivity Presenter
 * 2020-01-19
 *
 * @author
 */
public class BindAccountPresenter implements BindAccountContract.Presenter, OnRetrofits {

    private BindAccountContract.Model model;
    private BindAccountContract.View view;

    public BindAccountPresenter(BindAccountContract.View view) {
        this.view = view;
        model = new BindAccountModel(this);
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
