package com.example.astc.view.activity.mine;

import androidx.appcompat.widget.AppCompatButton;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.views.ClearEditText;

import butterknife.BindView;

/**
 * 绑定ASTC
 * 2020-01-11
 *
 * @author
 */
public class PayAstcActivity extends BaseLazyActivity {

    @BindView(R.id.et_pay_astc)
    ClearEditText etPayAstc;
    @BindView(R.id.bu_pay_astc)
    AppCompatButton buPayAstc;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_astc;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
