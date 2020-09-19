package com.example.astc.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;

import com.hjq.toast.ToastUtils;

/**
 * 项目中的 Dialog 基类
 * 2020-01-05
 *
 * @author
 */
public final class DialogFragment {

    public static class Builder<B extends DialogFragment.Builder>
            extends BaseDialogFragment.Builder<B> {

        public Builder(FragmentActivity activity) {
            super(activity);
        }

        @Override
        public B setContentView(@NonNull View view) {
            return super.setContentView(view);
        }

        /**
         * 显示吐司
         */
        public void toast(CharSequence text) {
            ToastUtils.show(text);
        }

        public void toast(@StringRes int id) {
            ToastUtils.show(id);
        }

        public void toast(Object object) {
            ToastUtils.show(object);
        }
    }
}