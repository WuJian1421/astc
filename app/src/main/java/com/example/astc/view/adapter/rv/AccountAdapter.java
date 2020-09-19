package com.example.astc.view.adapter.rv;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.astc.R;
import com.example.astc.bean.GetBalanceBean;
import com.example.astc.util.views.ImageLoader;

import java.util.List;

/**
 * 账户资产适配器
 * 2020-01-16
 *
 * @author
 */
public class AccountAdapter extends BaseQuickAdapter<GetBalanceBean.DataBean.UserWalletsBean,
        BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public AccountAdapter(int layoutResId, @Nullable List<GetBalanceBean.DataBean.UserWalletsBean> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, GetBalanceBean.DataBean.UserWalletsBean item) {
        //货币图标
//        ImageUtil.loadImageViewFromNet(helper.getConvertView().getContext(), item.getCoinImg(),
//                R.mipmap.ic_launcher, helper.getView(R.id.item_iv_monetary));
        ImageLoader.with(helper.getConvertView().getContext()).load(item.getCoinImg()).into(helper.getView(R.id.item_iv_monetary));
        //货币名字
        helper.setText(R.id.item_tv_currency_name, item.getCoinName());
        //货币地址
        helper.setText(R.id.item_tv_currency_address, item.getAddress());
    }
}
