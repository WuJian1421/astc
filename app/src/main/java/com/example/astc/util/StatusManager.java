package com.example.astc.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.astc.R;
import com.example.astc.util.views.HintLayout;
import com.example.astc.view.dialog.BaseDialog;
import com.example.astc.view.dialog.WaitDialog;

/**
 * 界面状态管理类
 * 2020-01-09
 *
 * @author
 */
public final class StatusManager {

    /**
     * 加载对话框
     */
    private BaseDialog mDialog;

    /**
     * 提示布局
     */
    private HintLayout mHintLayout;

    /**
     * 智能获取布局中的 HintLayout 对象
     */
    private static HintLayout findHintLayout(ViewGroup group) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View view = group.getChildAt(i);
            if ((view instanceof HintLayout)) {
                return (HintLayout) view;
            } else if (view instanceof ViewGroup) {
                HintLayout layout = findHintLayout((ViewGroup) view);
                if (layout != null) {
                    return layout;
                }
            }
        }
        return null;
    }

    /**
     * 显示加载中
     */
    public void showLoading(FragmentActivity activity) {
        showLoading(activity, activity.getString(R.string.loading));
    }

    public void showLoading(FragmentActivity activity, CharSequence text) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (mDialog == null) {
            mDialog = new WaitDialog.Builder(activity)
                    .setMessage(text)
                    .create();
        }
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }

    /**
     * 显示加载完成
     */
    public void showComplete() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        if (mHintLayout != null && mHintLayout.isShow()) {
            mHintLayout.hide();
        }
    }

    /**
     * 显示空提示
     */
    public void showEmpty(View view) {
        showLayout(view, R.mipmap.ic_launcher, R.string.network_connection_failed);
    }

    /**
     * 显示错误提示
     */
    public void showError(View view) {

    }

    /**
     * 显示自定义提示
     */
    public void showLayout(View view, @DrawableRes int drawableId, @StringRes int stringId) {
        showLayout(view, ContextCompat.getDrawable(view.getContext(), drawableId), view.getResources().getString(stringId));
    }

    public void showLayout(View view, Drawable drawable, CharSequence hint) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }

        if (mHintLayout == null) {
            if (view instanceof HintLayout) {
                mHintLayout = (HintLayout) view;
            } else if (view instanceof ViewGroup) {
                mHintLayout = findHintLayout((ViewGroup) view);
            }
            if (mHintLayout == null) {
                // 必须在布局中定义一个 HintLayout
                throw new IllegalStateException("You didn't add this HintLayout to your layout");
            }
        }
        mHintLayout.show();
        mHintLayout.setIcon(drawable);
        mHintLayout.setHint(hint);
    }
}