package com.example.astc.view.activity.home;

import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.view.adapter.rv.SearchForAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

/**
 * 搜索
 * 2019-12-26
 *
 * @author
 */
public class SearchForActivity extends BaseLazyActivity {

    @BindView(R.id.item_et_sf)
    EditText itemEtSf;
    @BindView(R.id.rv_sf)
    RecyclerView rvSf;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_for;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        //Rv
        SearchForAdapter searchForAdapter = new SearchForAdapter(R.layout.item_rv_search_for,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.rv_search_for))),
                new ArrayList<>(Arrays.asList(R.mipmap.app_quotes, R.mipmap.app_recharge, R.mipmap.app_data_recharge, R.mipmap.app_train_ticket)));
        rvSf.setAdapter(searchForAdapter);
        searchForAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (position) {
                case 0:

                    break;
                case 1:

                    break;
                default:
                    break;
            }
        });
    }
}
