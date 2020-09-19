package com.example.astc.view.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ViewHolders
 * 2019-12-14
 *
 * @author
 */
public class ViewHolders {
    private final SparseArray<View> sparseArray;
    private View mView;

    /**
     * 实例化
     *
     * @param context
     * @param viewGroup
     * @param Layout
     * @param position
     */
    private ViewHolders(Context context, ViewGroup viewGroup, int Layout, int position) {
        this.sparseArray = new SparseArray<>();
        mView = LayoutInflater.from(context).inflate(Layout, viewGroup, false);
        mView.setTag(this);
    }

    /**
     * 拿到 ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param viewGroup
     * @param layout
     * @param posttion
     * @return
     */
    public static ViewHolders getView(Context context, View convertView, ViewGroup viewGroup, int layout, int posttion) {
        if (convertView == null) {
            return new ViewHolders(context, viewGroup, layout, posttion);
        }
        return (ViewHolders) convertView.getTag();
    }

    /**
     * 通过ID获取控件,没有则加入sparseArray
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getId(int id) {
        View view = sparseArray.get(id);
        if (view == null) {
            view = mView.findViewById(id);
            sparseArray.put(id, view);
        }
        return (T) view;
    }

    /**
     * 返回
     *
     * @return
     */
    public View convertView() {
        return mView;
    }
}
