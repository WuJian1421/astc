package com.example.astc.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.astc.R;

import java.util.List;

/**
 * GridView适配器
 * 2019-12-15
 *
 * @author
 */
public class BaseGridViewAdapter extends BaseAdapters<String> {
    private List<Integer> icons;

    public BaseGridViewAdapter(Context context, List<String> data, List<Integer> icons) {
        super(context, data);
        this.icons = icons;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolders viewHolders = ViewHolders.getView(getContext(), view, viewGroup, R.layout.item_main_grid, i);
        ImageView imageView = viewHolders.getId(R.id.iv_item_mg);
        imageView.setImageResource(icons.get(i));
        TextView textView = viewHolders.getId(R.id.tv_item_mg);
        textView.setText(getData().get(i));
        return viewHolders.convertView();
    }
}
