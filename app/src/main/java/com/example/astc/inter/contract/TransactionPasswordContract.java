package com.example.astc.inter.contract;

import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.inter.OnRetrofits;

import org.json.JSONObject;

/**
 * 设置/修改交易密码 MVP
 * 2020-01-16
 *
 * @author
 */
public interface TransactionPasswordContract {
    interface Model {
        /**
         * 获取助记词
         *
         * @param jsonbObject
         * @param onRetrofits
         */
        void getCall(JSONObject jsonbObject, OnRetrofits onRetrofits);

        /**
         * 设置/修改交易密码
         *
         * @param jsonbObject
         * @param onRetrofits
         */
        void getPassword(JSONObject jsonbObject, OnRetrofits onRetrofits);
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
         * @param getMemoByUserNameBean
         */
        void getData(GetMemoByUserNameBean getMemoByUserNameBean);

        /**
         * 传递
         *
         * @return
         */
        JSONObject getPasswordJson();

        /**
         * 接收数据
         *
         * @param baseBean
         */
        void getTransactionPassword(BaseBean baseBean);
    }

    interface Presenter {
        /**
         * 获取助记词
         */
        void methodCall();

        /**
         * 返回数据-助记词
         *
         * @param getMemoByUserNameBean
         */
        void getData(GetMemoByUserNameBean getMemoByUserNameBean);

        /**
         * 提交设置/修改交易密码
         */
        void methodSubmitCall();

        /**
         * 返回数据-提交成功/失败
         *
         * @param baseBean
         */
        void getSubmitData(BaseBean baseBean);
    }
}
