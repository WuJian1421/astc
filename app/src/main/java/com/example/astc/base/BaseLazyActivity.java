package com.example.astc.base;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.example.astc.R;
import com.example.astc.action.TitleBarAction;
import com.example.astc.helper.ActivityStackManager;
import com.example.astc.util.StatusManager;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.bar.TitleBar;

import butterknife.ButterKnife;

/**
 * 项目中的 Activity 基类
 * 2020-01-06
 *
 * @author
 */
public abstract class BaseLazyActivity extends BaseActivity
        implements TitleBarAction {

    private final StatusManager mStatusManager = new StatusManager();
    /**
     * 标题栏对象
     */
    private TitleBar mTitleBar;
    /**
     * 状态栏沉浸
     */
    private ImmersionBar mImmersionBar;

    /**
     * 获取标题栏 id
     */
    protected int getTitleId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getTitleBar() != null) {
            getTitleBar().setOnTitleBarListener(this);
        }
        ActivityStackManager.getInstance().onCreated(this);
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        // 初始化标题栏的监听
        if (getTitleId() > 0) {
            // 勤快模式
            View view = findViewById(getTitleId());
            if (view instanceof TitleBar) {
                mTitleBar = (TitleBar) view;
            }
        } else if (getTitleId() == 0) {
            // 懒人模式
            mTitleBar = findTitleBar(getContentView());
        }
        if (mTitleBar != null) {
            mTitleBar.setOnTitleBarListener(this);
        }

        ButterKnife.bind(this);
        initImmersion();
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersion() {
        // 初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            statusBarConfig().init();

            // 设置标题栏沉浸
            if (getTitleId() > 0) {
                ImmersionBar.setTitleBar(this, findViewById(getTitleId()));
            } else if (mTitleBar != null) {
                ImmersionBar.setTitleBar(this, mTitleBar);
            }
        }
    }

    /**
     * 是否使用沉浸式状态栏
     */
    public boolean isStatusBarEnabled() {
        return true;
    }

    /**
     * 获取状态栏沉浸的配置对象
     */
    public ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    public boolean statusBarDarkFont() {
        // 返回真表示黑色字体
        return true;
    }

    /**
     * 初始化沉浸式状态栏
     */
    protected ImmersionBar statusBarConfig() {
        // 在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                // 默认状态栏字体颜色为黑色
                .statusBarDarkFont(statusBarDarkFont());
        return mImmersionBar;
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (mTitleBar != null) {
            mTitleBar.setTitle(title);
        }
    }

    @Override
    @Nullable
    public TitleBar getTitleBar() {
        if (mTitleBar == null) {
            mTitleBar = findTitleBar(getContentView());
        }
        return mTitleBar;
    }

    @Override
    public void onLeftClick(View v) {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStackManager.getInstance().onDestroyed(this);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out);
    }

    /**
     * 显示加载中
     */
    public void showLoading() {
        mStatusManager.showLoading(this);
    }

    public void showLoading(@StringRes int id) {
        mStatusManager.showLoading(this, getString(id));
    }

    public void showLoading(CharSequence text) {
        mStatusManager.showLoading(this, text);
    }

    /**
     * 显示加载完成
     */
    public void showComplete() {
        mStatusManager.showComplete();
    }

    /**
     * 显示空提示
     */
    public void showEmpty() {
        mStatusManager.showEmpty(getContentView());
    }

    /**
     * 显示错误提示
     */
    public void showError() {
        mStatusManager.showError(getContentView());
    }

    /**
     * 显示自定义提示
     */
    public void showLayout(@DrawableRes int drawableId, @StringRes int stringId) {
        mStatusManager.showLayout(getContentView(), drawableId, stringId);
    }

    public void showLayout(Drawable drawable, CharSequence hint) {
        mStatusManager.showLayout(getContentView(), drawable, hint);
    }
}