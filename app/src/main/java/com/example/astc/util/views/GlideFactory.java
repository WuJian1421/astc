package com.example.astc.util.views;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.astc.R;
import com.example.astc.inter.ImageFactory;

/**
 * Glide 加工厂
 * 2020-01-06
 *
 * @author
 */
public final class GlideFactory implements ImageFactory<GlideStrategy> {

    @Override
    public GlideStrategy createImageStrategy() {
        return new GlideStrategy();
    }

    @Override
    public Drawable createPlaceholder(Context context) {
        return ContextCompat.getDrawable(context, R.mipmap.image_loading);
    }

    @Override
    public Drawable createError(Context context) {
        return ContextCompat.getDrawable(context, R.mipmap.image_load_err);
    }

    @Override
    public void clearMemoryCache(Context context) {
        // 清除内存缓存（必须在主线程）
        Glide.get(context).clearMemory();
    }

    @Override
    public void clearDiskCache(final Context context) {
        new Thread(() -> {
            // 清除本地缓存（必须在子线程）
            Glide.get(context).clearDiskCache();
        }).start();
    }
}