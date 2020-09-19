package com.example.astc.view.activity.mine;

import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatButton;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.views.ClearEditText;
import com.hjq.toast.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 申诉记录-填写申诉
 * 2020-01-09
 *
 * @author
 */
public class FillInTheAppealActivity extends BaseLazyActivity {

    @BindView(R.id.et_appeal1)
    ClearEditText etAppeal1;
    @BindView(R.id.et_appeal2)
    ClearEditText etAppeal2;
    @BindView(R.id.bu_appeal)
    AppCompatButton buAppeal;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_fill_in_the_appeal;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    @OnClick(R.id.bu_appeal)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(etAppeal1.getText().toString().trim())) {

        } else {
            ToastUtils.show(R.string.please_enter_your_appeal);
        }
    }
}
