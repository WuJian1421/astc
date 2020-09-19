package com.example.astc.view.activity.home;

import android.content.Context;
import android.content.Intent;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.views.photo.PhotoViewPager;
import com.example.astc.view.adapter.ImagePagerAdapter;
import com.gyf.immersionbar.BarHide;
import com.rd.PageIndicatorView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 查看大图
 * 2020-01-06
 *
 * @author
 */
public class ImageActivity extends BaseLazyActivity {

    @BindView(R.id.pv_p_image)
    PhotoViewPager pvPImage;
    @BindView(R.id.pi_v_image)
    PageIndicatorView piVImage;

    public static void start(Context context, String url) {
        ArrayList<String> images = new ArrayList<>(1);
        images.add(url);
        start(context, images);
    }

    public static void start(Context context, ArrayList<String> urls) {
        start(context, urls, 0);
    }

    public static void start(Context context, ArrayList<String> urls, int index) {
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra("picture", urls);
        intent.putExtra("index", index);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image;
    }

    @Override
    protected void initData() {
        // 设置状态栏和导航栏参数
        getStatusBarConfig()
                // 有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
                .fullScreen(true)
                // 隐藏状态栏
                .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                // 透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
                .transparentNavigationBar()
                .init();
        piVImage.setViewPager(pvPImage);

        ArrayList<String> images = getIntent().getStringArrayListExtra("picture");
        int index = getIntent().getIntExtra("index", 0);
        if (images != null && images.size() > 0) {
            pvPImage.setAdapter(new ImagePagerAdapter(this, images));
            if (index != 0 && index <= images.size()) {
                pvPImage.setCurrentItem(index);
            }
        } else {
            finish();
        }
    }

    @Override
    public boolean statusBarDarkFont() {
        return false;
    }
}