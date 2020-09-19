package com.example.astc.view.fragment.main;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.view.activity.conversation.DialogueActivity;

/**
 * 首页-会话
 * 2019-12-20
 *
 * @author
 */
public class ConversationFragment extends BaseLazyFragment<MainActivity> implements
        BaseQuickAdapter.OnItemChildClickListener {

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_conversation;
    }

    @Override
    public boolean isStatusBarEnabled() {
        return !super.isStatusBarEnabled();
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
    }

    /**
     * callback method to be invoked when an item in this view has been
     * click and held
     *
     * @param adapter
     * @param view     The view whihin the ItemView that was clicked
     * @param position The position of the view int the adapter
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(DialogueActivity.class);
    }
}