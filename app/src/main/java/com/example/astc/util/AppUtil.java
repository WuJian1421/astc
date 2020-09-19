package com.example.astc.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;

import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.protocol.BasisProtocol;
import com.hjq.toast.ToastUtils;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.MediaType;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.Manifest.permission.ACCESS_NETWORK_STATE;

/**
 * 工具类
 * 2019-10-16
 *
 * @author
 */
public class AppUtil {

    /**
     * 获取Protocol
     *
     * @return
     */
    public static BasisProtocol getProtocolTest() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Applications.getNetworkingUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(BasisProtocol.class);
    }

    /**
     * 返回MediaType json
     *
     * @return
     */
    public static MediaType getMediaType() {
        return MediaType.parse("application/json");
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return
     */
    public static boolean isObject(Object object) {
        return null != object;
    }

    /**
     * 网络是否已连接
     *
     * @return true:已连接 false:未连接
     */
    @SuppressWarnings("deprecation")
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean iConnected(@NonNull Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities networkCapabilities = manager.getNetworkCapabilities(manager.getActiveNetwork());
                if (networkCapabilities != null) {
                    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET);
                }
            } else {
                NetworkInfo networkInfo = manager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
        }
        return false;
    }

    /**
     * MD5加密
     *
     * @param string
     * @return
     */
    public static String md5(String string) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 实现全局对象类
     *
     * @param activity
     * @param dataBean
     */
    public static void getAppNewLogin(Activity activity, NewLoginBean.DataBean dataBean) {
        Applications applications = (Applications) activity.getApplication();
        applications.setNewLoginBean(dataBean);
    }

    /**
     * 设置BottomNavigationViewEx只显示文字
     *
     * @param viewEx
     * @return
     */
    public static BottomNavigationViewEx setNoIcon(BottomNavigationViewEx viewEx) {
        viewEx.setIconVisibility(false);
        viewEx.enableAnimation(false);
        viewEx.enableShiftingMode(false);
        viewEx.enableItemShiftingMode(false);
        return viewEx;
    }

    /**
     * 保存图片
     *
     * @param context
     * @param bitmap
     */
    public static void saveBitmap(Context context, Bitmap bitmap) {
        try {
            // 获取内置SD卡路径
            String sdCardPath = Environment.getExternalStorageDirectory().getPath();
            // 图片文件路径
            File file = new File(sdCardPath);
            File[] files = file.listFiles();
            assert files != null;
            for (File file1 : files) {
                String name = file1.getName();
                if (name.endsWith("code.png")) {
                    //判断图片是否存在，存在删除
                    file1.delete();
                }
            }
            String filePath = sdCardPath + "/code.png";
            file = new File(filePath);
            FileOutputStream os = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);
            os.flush();
            os.close();

            //保存图片后发送广播通知更新数据库
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            ToastUtils.show(R.string.saved_successfully);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}