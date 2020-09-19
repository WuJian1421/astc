package com.example.astc.inter.presenter;

import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetIDCardBean;
import com.example.astc.inter.OnRetrofits;
import com.example.astc.inter.contract.IndividualCertificationContract;
import com.example.astc.inter.model.IndividualCertificationModel;

/**
 * IndividualCertificationActivity Presenter
 * 2020-01-19
 *
 * @author
 */
public class IndividualCertificationPresenter implements IndividualCertificationContract.Presenter, OnRetrofits {

    private IndividualCertificationContract.Model model;
    private IndividualCertificationContract.View view;

    public IndividualCertificationPresenter(IndividualCertificationContract.View view) {
        this.view = view;
        model = new IndividualCertificationModel(this);
    }

    /**
     * 查询认证状态
     */
    @Override
    public void methodCall() {
        model.getCall(view.getDataJson(), this);
    }

    /**
     * 返回数据-状态
     *
     * @param getIDCardBean
     */
    @Override
    public void getData(GetIDCardBean getIDCardBean) {
        view.getData(getIDCardBean);
    }

    /**
     * 提交认证资料
     */
    @Override
    public void methodSubmitCall() {
        model.getSubmitCall(view.getSubmitDataJson(), this);
    }

    /**
     * 返回数据-提交
     *
     * @param baseBean
     */
    @Override
    public void getSubmitData(BaseBean baseBean) {
        view.getSubmitData(baseBean);
    }

    /**
     * 成功
     */
    @Override
    public void onSuccess() {

    }

    /**
     * 失败
     */
    @Override
    public void onFailure() {

    }
}
