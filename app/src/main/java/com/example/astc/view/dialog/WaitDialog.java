package com.example.astc.view.dialog;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;

import com.example.astc.R;
import com.example.astc.base.DialogFragment;

/**
 * 等待加载对话框
 * 2020-01-07
 *
 * @author
 */
public final class WaitDialog {

    public static class Builder extends DialogFragment.Builder<Builder> {

        private TextView mMessageView;

        public Builder(FragmentActivity activity) {
            super(activity);
            setContentView(R.layout.dialog_wait);
            setAnimStyle(BaseDialog.AnimStyle.TOAST);
            setBackgroundDimEnabled(false);
            setCancelable(false);
            mMessageView = findViewById(R.id.tv_wait_message);
        }

        public Builder setMessage(@StringRes int id) {
            return setMessage(getString(id));
        }

        public Builder setMessage(CharSequence text) {
            mMessageView.setText(text);
            mMessageView.setVisibility(text == null ? View.GONE : View.VISIBLE);
            return this;
        }
    }
}