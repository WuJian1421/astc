package com.example.astc.inter.contract;

import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetIDCardBean;
import com.example.astc.inter.OnRetrofits;

import org.json.JSONObject;

/**
 * 个人认证 MVP
 * 2020-01-19
 *
 * @author
 */
public interface IndividualCertificationContract {
    interface Model {
        /**
         * 查询认证状态
         *
         * @param jsonbObject
         * @param onRetrofits
         */
        void getCall(JSONObject jsonbObject, OnRetrofits onRetrofits);

        /**
         * 提交认证资料
         *
         * @param jsonbObject
         * @param onRetrofits
         */
        void getSubmitCall(JSONObject jsonbObject, OnRetrofits onRetrofits);
    }

    interface View {
        /**
         * 运行加载ing...
         */
        void startLoading();

        /**
         * 结束加载ing...
         */
        void endLoading();

        /**
         * 传递
         *
         * @return
         */
        JSONObject getDataJson();

        /**
         * 接收数据
         *
         * @param getIDCardBean
         */
        void getData(GetIDCardBean getIDCardBean);

        /**
         * 传递
         *
         * @return
         */
        JSONObject getSubmitDataJson();

        /**
         * 接收数据
         *
         * @param baseBean
         */
        void getSubmitData(BaseBean baseBean);
    }

    interface Presenter {
        /**
         * 查询认证状态
         */
        void methodCall();

        /**
         * 返回数据-状态
         *
         * @param getIDCardBean
         */
        void getData(GetIDCardBean getIDCardBean);

        /**
         * 提交认证资料
         */
        void methodSubmitCall();

        /**
         * 返回数据-提交
         *
         * @param baseBean
         */
        void getSubmitData(BaseBean baseBean);
    }
}
