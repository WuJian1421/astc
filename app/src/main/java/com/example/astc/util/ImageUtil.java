package com.example.astc.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * 图片类工具
 * 2019-12-29
 *
 * @author
 */
public class ImageUtil {

    /**
     * 加载通用网络图片
     *
     * @param context
     * @param url
     * @param error
     * @param view
     */
    public static void loadImageViewFromNet(Context context, String url, int error, ImageView view) {
        RequestOptions options = new RequestOptions().centerCrop().error(error)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        Glide.with(context).load(url).apply(options).into(view);
    }
}
