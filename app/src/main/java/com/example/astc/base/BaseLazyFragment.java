package com.example.astc.base;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.example.astc.action.TitleBarAction;
import com.example.astc.util.StatusManager;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.ButterKnife;

/**
 * 项目中 Fragment 懒加载基类
 * 2020-01-06
 *
 * @author
 */
public abstract class BaseLazyFragment<A extends BaseLazyActivity>
        extends BaseFragment<A> implements OnTitleBarListener, TitleBarAction {

    private final StatusManager mStatusManager = new StatusManager();
    /**
     * 标题栏对象
     */
    private TitleBar mTitleBar;
    /**
     * 状态栏沉浸
     */
    private ImmersionBar mImmersionBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initFragment() {
        ButterKnife.bind(this, getView());
        if (getTitleBar() != null) {
            getTitleBar().setOnTitleBarListener(this);
        }
        initImmersion();
        super.initFragment();
    }

    /**
     * 初始化沉浸式
     */
    private void initImmersion() {
        // 初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            statusBarConfig().init();
            // 设置标题栏沉浸
            if (mTitleBar != null) {
                ImmersionBar.setTitleBar(this, mTitleBar);
            }
        }
    }

    /**
     * 是否在Fragment使用沉浸式
     */
    public boolean isStatusBarEnabled() {
        return false;
    }

    /**
     * 获取状态栏沉浸的配置对象
     */
    protected ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    /**
     * 初始化沉浸式
     */
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                // 默认状态栏字体颜色为黑色
                .statusBarDarkFont(statusBarDarkFont())
                // 解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .keyboardEnable(true);
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    private boolean statusBarDarkFont() {
        // 返回真表示黑色字体
        return true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isStatusBarEnabled() && isLazyLoad()) {
            // 重新初始化状态栏
            statusBarConfig().init();
        }
    }

    @Override
    @Nullable
    public TitleBar getTitleBar() {
        if (mTitleBar == null) {
            mTitleBar = findTitleBar((ViewGroup) getView());
        }
        return mTitleBar;
    }

    /**
     * 显示加载中
     */
    public void showLoading() {
        mStatusManager.showLoading(getAttachActivity());
    }

    public void showLoading(@StringRes int id) {
        mStatusManager.showLoading(getAttachActivity(), getString(id));
    }

    public void showLoading(CharSequence text) {
        mStatusManager.showLoading(getAttachActivity(), text);
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
        mStatusManager.showEmpty(getView());
    }

    /**
     * 显示错误提示
     */
    public void showError() {
        mStatusManager.showError(getView());
    }

    /**
     * 显示自定义提示
     */
    public void showLayout(@DrawableRes int drawableId, @StringRes int stringId) {
        mStatusManager.showLayout(getView(), drawableId, stringId);
    }

    public void showLayout(Drawable drawable, CharSequence hint) {
        mStatusManager.showLayout(getView(), drawable, hint);
    }
}