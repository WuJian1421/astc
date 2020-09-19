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
 * 应用-游戏娱乐
 * 2019-12-27
 *
 * @author
 */
public class GameEntertainmentFragment extends BaseLazyFragment<MainActivity> implements AdapterView.OnItemClickListener {

    @BindView(R.id.gv_ge)
    BaseGridView gvGe;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_game_entertainment;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //GridView
        BaseGridViewAdapter baseGridViewAdapter = new BaseGridViewAdapter(context,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.gv_ge))),
                new ArrayList<>(Arrays.asList(R.mipmap.landlord, R.mipmap.flush)));
        gvGe.setAdapter(baseGridViewAdapter);
        gvGe.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                //斗地主
                break;
            case 1:
                //同花顺
                break;
            default:
                break;
        }
    }
}
