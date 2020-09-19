package com.example.astc.view.activity;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.views.SmartTextView;
import com.hjq.toast.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 服务及隐私条款
 * 2019-12-31
 *
 * @author
 */
public class ServiceTipsActivity extends BaseLazyActivity {

    @BindView(R.id.tv_st)
    SmartTextView tvSt;
    @BindView(R.id.cb_st)
    AppCompatCheckBox cbSt;
    @BindView(R.id.tv_st_pp)
    AppCompatTextView tvStPp;
    @BindView(R.id.bu_st)
    AppCompatButton buSt;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_service_tips;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        String tips = getString(R.string.service_tips);
        SpannableString sanest = new SpannableString(tips);
        sanest.setSpan(new TextClick(), 0, tips.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvStPp.setText(getString(R.string.privacy_policy));
        tvStPp.append(sanest);
        tvStPp.setMovementMethod(LinkMovementMethod.getInstance());
        tvStPp.setHighlightColor(Color.TRANSPARENT);
        cbSt.setChecked(true);
    }

    @OnClick(R.id.bu_st)
    public void onViewClicked() {
        if (cbSt.isChecked()) {
            finish();
        } else {
            ToastUtils.show(getString(R.string.please_agree) + getString(R.string.service_tips));
        }
    }

    /**
     * 颜色文字点击事件
     */
    public class TextClick extends ClickableSpan {

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(getResources().getColor(R.color.yellow));
        }

        @Override
        public void onClick(View widget) {
        }
    }
}
