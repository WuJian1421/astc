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
 * 我的-系统设置
 * 2019-12-31
 *
 * @author
 */
public class SystemSettingsActivity extends BaseLazyActivity {

    @BindView(R.id.rv_ss)
    RecyclerView rvSs;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_settings;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        //Rv
        SystemSettingAdapter systemSettingAdapter = new SystemSettingAdapter(R.layout.item_rv_ss,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.rv_system_settings))));
        rvSs.setAdapter(systemSettingAdapter);
        systemSettingAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (position) {
                case 0:
                    //修改登录密码
                    startActivity(ModifyLoginPasswordActivity.class);
                    break;
                case 1:
                    //修改交易密码
                    Intent intent = new Intent(this, TransactionPasswordActivity.class);
                    intent.putExtra("type", 1);
                    startActivity(intent);
                    break;
                case 2:
                    //支付方式
                    startActivity(PaymentMethodActivity.class);
                    break;
                default:
                    break;
            }
        });
    }
}
