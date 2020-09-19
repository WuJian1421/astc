package com.example.astc.view.adapter.rv;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.astc.R;

import java.util.List;

/**
 * 我的-Rv适配器
 * 2019-12-27
 *
 * @author
 */
public class MineRvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private List<Integer> integers;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public MineRvAdapter(int layoutResId, @Nullable List<String> data, List<Integer> integers) {
        super(layoutResId, data);
        this.integers = integers;
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_tv_mine, item).addOnClickListener(R.id.item_ll_mine);
        helper.setBackgroundRes(R.id.item_iv_mine, integers.get(helper.getAdapterPosition()));
    }
}
