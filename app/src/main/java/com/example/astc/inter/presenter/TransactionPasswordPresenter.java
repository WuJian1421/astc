package com.example.astc.inter.presenter;

import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.TransactionPasswordContract;
import com.example.astc.inter.model.TransactionPasswordModel;

/**
 * TransactionPasswordActivity presenter
 * 2020-01-16
 *
 * @author
 */
public class TransactionPasswordPresenter implements TransactionPasswordContract.Presenter, OnRetrofits {

    private TransactionPasswordContract.View view;
    private TransactionPasswordContract.Model model;

    public TransactionPasswordPresenter(TransactionPasswordContract.View view) {
        this.view = view;
        model = new TransactionPasswordModel(this);
    }

    /**
     * 获取助记词
     */
    @Override
    public void methodCall() {
        view.startLoading();
        model.getCall(view.getDataJson(), this);
    }

    /**
     * 返回数据-助记词
     *
     * @param getMemoByUserNameBean
     */
    @Override
    public void getData(GetMemoByUserNameBean getMemoByUserNameBean) {
        view.getData(getMemoByUserNameBean);
    }

    /**
     * 提交设置/修改交易密码
     */
    @Override
    public void methodSubmitCall() {
        model.getPassword(view.getPasswordJson(), this);
    }

    /**
     * 返回数据-提交成功/失败
     *
     * @param baseBean
     */
    @Override
    public void getSubmitData(BaseBean baseBean) {
        view.getTransactionPassword(baseBean);
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
}
