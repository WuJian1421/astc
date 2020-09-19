package com.example.astc.view.activity.mine;

import android.view.View;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;

/**
 * 支付方式-银行卡绑定
 * 2020-01-09
 *
 * @author
 */
public class BindBankCardActivity extends BaseLazyActivity {

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_bank_card;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        startActivity(AddBankCardActivity.class);
    }
}
