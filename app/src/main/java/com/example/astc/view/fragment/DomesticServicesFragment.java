package com.example.astc.view.fragment;

import android.view.View;
import android.widget.AdapterView;

import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.util.views.BaseGridView;
import com.example.astc.view.adapter.BaseGridViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

/**
 * 应用-生活服务
 * 2019-12-27
 *
 * @author
 */
public class DomesticServicesFragment extends BaseLazyFragment<MainActivity>
        implements AdapterView.OnItemClickListener {

    @BindView(R.id.gv_ds)
    BaseGridView gvDs;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_domestic_services;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //GridView
        BaseGridViewAdapter baseGridViewAdapter = new BaseGridViewAdapter(context,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.gv_ds))),
                new ArrayList<>(Arrays.asList(R.mipmap.app_quotes, R.mipmap.app_recharge, R.mipmap.app_data_recharge, R.mipmap.app_train_ticket)));
        gvDs.setAdapter(baseGridViewAdapter);
        gvDs.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                //行情
                break;
            case 1:
                //话费充值
                break;
            case 2:
                //流量充值
                break;
            case 4:
                //火车票
                break;
            default:
                break;
        }
    }
}
