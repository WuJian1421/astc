package com.example.astc.inter.presenter;

import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.MnemonicContract;
import com.example.astc.inter.model.MnemonicModel;

/**
 * MnemonicFragment Presenter
 * 2019-12-25
 *
 * @author
 */
public class MnemonicPresenter implements MnemonicContract.Presenter, OnRetrofits {

    private MnemonicContract.View view;
    private MnemonicContract.Model model;

    public MnemonicPresenter(MnemonicContract.View mnemonicView) {
        this.view = mnemonicView;
        model = new MnemonicModel(this);
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
     * @param memoByUserNameBean
     */
    @Override
    public void getData(GetMemoByUserNameBean memoByUserNameBean) {
        view.getData(memoByUserNameBean);
    }

    /**
     * 提交助记词
     */
    @Override
    public void methodSubmitCall() {
        view.startLoading();
        model.getSubmitCall(view.getSubmitDataJson(), this);
    }

    /**
     * 返回数据-正确登录
     *
     * @param newLoginBean
     */
    @Override
    public void getSubmitData(NewLoginBean newLoginBean) {
        view.getSubmitData(newLoginBean);
    }
}
