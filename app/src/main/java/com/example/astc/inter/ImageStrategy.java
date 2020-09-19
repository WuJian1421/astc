package com.example.astc.inter;

import com.example.astc.util.views.ImageLoader;

/**
 * 图片加载策略接口
 * 2020-01-06
 *
 * @author
 */
public interface ImageStrategy {

    /**
     * 加载图片
     *
     * @param loader
     */
    void load(ImageLoader loader);
}