package com.example.astc.view.activity.mine;

import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.view.adapter.rv.SystemSettingAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

/**
 * 系统设置-支付方式
 * 2020-01-06
 *
 * @author
 */
public class PaymentMethodActivity extends BaseLazyActivity {

    @BindView(R.id.rv_pm)
    RecyclerView rvPm;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_payment_method;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //Rv
        SystemSettingAdapter systemSettingAdapter = new SystemSettingAdapter(R.layout.item_rv_ss,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.rv_pay))));
        rvPm.setAdapter(systemSettingAdapter);
        systemSettingAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (position) {
                case 0:
                    //绑定支付宝
                    Intent intent1 = new Intent(context, BindAccountActivity.class);
                    intent1.putExtra("account", 0);
                    startActivity(intent1);
                    break;
                case 1:
                    //绑定微信
                    Intent intent2 = new Intent(context, BindAccountActivity.class);
                    intent2.putExtra("account", 1);
                    startActivity(intent2);
                    break;
                case 2:
                    //绑定银行卡
                    startActivity(BindBankCardActivity.class);
                    break;
                case 3:
                    //绑定ASTC
                    startActivity(PayAstcActivity.class);
                    break;
                default:
                    break;
            }
        });
    }
}
