package com.example.astc.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.protocol.BasisProtocol;
import com.example.astc.util.views.ImageLoader;
import com.hjq.bar.TitleBar;
import com.hjq.bar.style.TitleBarNightStyle;
import com.hjq.language.LanguagesManager;
import com.hjq.toast.ToastInterceptor;
import com.hjq.toast.ToastUtils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Application
 * 2019-12-11
 *
 * @author
 */
public class Applications extends Application {
    public static String getNetworkingUrl = "http://47.52.233.73:8181/";
    public static int NetworkingCode = 200;
    public static String accessKey = "&AccessKey=9eb2b9091b0d417383295169fac8b373";
    private NewLoginBean.DataBean newLoginBean;
    private static BasisProtocol basisProtocol;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Toast
        ToastUtils.init(this);
        //初始化TitleBar
        TitleBar.initStyle(new TitleBarNightStyle(this));
        //初始化国际语言
        LanguagesManager.init(this);
        // 图片加载器
        ImageLoader.init(this);
        // 设置 Toast 拦截器
        ToastUtils.setToastInterceptor(new ToastInterceptor() {
            @Override
            public boolean intercept(Toast toast, CharSequence text) {
                boolean intercept = super.intercept(toast, text);
                if (intercept) {
                    Log.e("Toast", "空 Toast");
                } else {
                    Log.i("Toast", text.toString());
                }
                return intercept;
            }
        });
        //Retrofit
        basisProtocol = new Retrofit.Builder().baseUrl(Applications.getNetworkingUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(BasisProtocol.class);
    }

    /**
     * 获取Protocol
     *
     * @return
     */
    public static BasisProtocol getBasisProtocol() {
        return basisProtocol;
    }

    @Override
    protected void attachBaseContext(Context base) {
        // 国际化适配（绑定语种）
        super.attachBaseContext(LanguagesManager.attach(base));
    }

    public NewLoginBean.DataBean getNewLoginBean() {
        return newLoginBean;
    }

    public void setNewLoginBean(NewLoginBean.DataBean newLoginBean) {
        this.newLoginBean = newLoginBean;
    }
}
