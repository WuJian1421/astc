package com.example.astc.inter.contract;

import com.example.astc.inter.OnRetrofits;

import retrofit2.Call;

/**
 * 绑定支付宝/微信
 * 2020-01-19
 *
 * @author
 */
public interface BindAccountContract {
    interface Model {
        /**
         * 获取数据
         *
         * @param tCall
         * @param onRetrofits
         */
        void getCall(Call tCall, OnRetrofits onRetrofits);
    }

    interface View<T> {
        /**
         * 运行加载ing...
         */
        void startLoading();

        /**
         * 结束加载ing...
         */
        void endLoading();

        /**
         * 传递Call
         *
         * @return
         */
        Call setCall();

        /**
         * 接收数据
         *
         * @param t
         */
        void getData(T t);
    }

    interface Presenter<T> {
        /**
         * 请求数据
         */
        void methodCall();

        /**
         * 返回数据
         *
         * @param t
         */
        void getData(T t);
    }
}
