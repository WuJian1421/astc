package com.example.astc.inter.contract;

import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.OnRetrofits;

import org.json.JSONObject;

/**
 * 助记词 MVP
 * 2020-01-16
 *
 * @author
 */
public interface MnemonicContract {
    interface Model {
        /**
         * 获取助记词
         *
         * @param jsonbObject
         * @param onRetrofits
         */
        void getCall(JSONObject jsonbObject, OnRetrofits onRetrofits);

        /**
         * 助记词登录
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
         * @param getMemoByUserNameBean
         */
        void getData(GetMemoByUserNameBean getMemoByUserNameBean);

        /**
         * 传递
         *
         * @return
         */
        JSONObject getSubmitDataJson();

        /**
         * 接收数据
         *
         * @param newLoginBean
         */
        void getSubmitData(NewLoginBean newLoginBean);
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
         * 提交助记词
         */
        void methodSubmitCall();

        /**
         * 返回数据-正确登录
         *
         * @param newLoginBean
         */
        void getSubmitData(NewLoginBean newLoginBean);
    }
}
