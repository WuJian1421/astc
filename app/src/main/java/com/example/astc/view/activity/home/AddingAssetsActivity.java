package com.example.astc.view.activity.home;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;

import butterknife.BindView;

/**
 * 添加资产
 * 2020-01-17
 *
 * @author
 */
public class AddingAssetsActivity extends BaseLazyActivity {

    @BindView(R.id.rv_assets)
    RecyclerView rvAssets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_adding_assets;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
