package com.example.astc.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.astc.R;
import com.example.astc.bean.DialogueBean;

import java.util.List;

/**
 * 聊天适配器
 * 2020-01-11
 *
 * @author
 */
public class DialogueAdapter extends BaseQuickAdapter<DialogueBean, BaseViewHolder> {
    private int left = 2;
    private int right = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public DialogueAdapter(int layoutResId, @Nullable List<DialogueBean> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, DialogueBean item) {
        if (item.getType() == left) {
            helper.setVisible(R.id.item_right_tv, false);
            helper.setVisible(R.id.item_left_tv, true);
            helper.setText(R.id.item_left_tv, item.getMessage());
        } else if (item.getType() == right) {
            helper.setVisible(R.id.item_right_tv, true);
            helper.setVisible(R.id.item_left_tv, false);
            helper.setText(R.id.item_right_tv, item.getMessage());
        }
    }
}
