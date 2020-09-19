package com.example.astc.view.adapter.rv;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.astc.R;
import com.example.astc.bean.ConversationBean;

import java.util.List;

/**
 * 会话适配器
 * 2020-01-11
 *
 * @author
 */
public class ConversationAdapter extends BaseQuickAdapter<ConversationBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public ConversationAdapter(int layoutResId, @Nullable List<ConversationBean> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, ConversationBean item) {
        helper.setText(R.id.item_tv_nickname_conversation, item.getNickName())
                .setText(R.id.item_tv_time_conversation, item.getTime())
                .setText(R.id.item_tv_content_conversation, item.getContent());
        helper.addOnClickListener(R.id.item_ll_conversation);
    }
}
