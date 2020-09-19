package com.example.astc.view.adapter.rv;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.astc.R;

import java.util.List;

/**
 * 关于我们-Rv适配器
 * 2019-12-31
 *
 * @author
 */
public class AboutUsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public AboutUsAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_tv_au, item).addOnClickListener(R.id.item_ll_au);
        switch (helper.getAdapterPosition()) {
            case 0:
                helper.setVisible(R.id.iv_right_arrow, false);
                helper.setVisible(R.id.tv_right_arrow, true);
                break;
            case 1:
                helper.setVisible(R.id.iv_right_arrow, false);
                break;
            default:
                break;
        }
    }
}
