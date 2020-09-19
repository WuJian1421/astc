package com.example.astc.view.activity.mine;

import androidx.appcompat.widget.AppCompatButton;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.views.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 银行卡绑定-添加
 * 2020-01-09
 *
 * @author
 */
public class AddBankCardActivity extends BaseLazyActivity {

    @BindView(R.id.et_add_bank1)
    ClearEditText etAddBank1;
    @BindView(R.id.et_add_bank2)
    ClearEditText etAddBank2;
    @BindView(R.id.et_add_bank3)
    ClearEditText etAddBank3;
    @BindView(R.id.et_add_bank4)
    ClearEditText etAddBank4;
    @BindView(R.id.bu_add_bank)
    AppCompatButton buAddBank;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_bank_card;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    @OnClick(R.id.bu_add_bank)
    public void onViewClicked() {
    }
}
