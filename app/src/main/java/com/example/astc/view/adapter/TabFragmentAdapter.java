package com.example.astc.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.astc.R;

import java.util.List;

/**
 * TabFragment
 * 2019-12-14
 *
 * @author
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {
    private List<String> tabText;
    private List<Fragment> fragments;
    private Context context;

    public TabFragmentAdapter(@NonNull FragmentManager fm, int behavior, List<String> tabText,
                              List<Fragment> fragments, Context context) {
        super(fm, behavior);
        this.tabText = tabText;
        this.fragments = fragments;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return tabText.size();
    }

    /**
     * TabView
     *
     * @param position
     * @return
     */
    public View getTabView(int position) {
        return getTabView(position, true, 0);
    }

    /**
     * TabView
     *
     * @param position
     * @param isImView
     * @return
     */
    public View getTabView(int position, boolean isImView, Integer integer) {
        ViewHolders viewHolders = ViewHolders.getView(context, null, null, R.layout.item_main_grid, position);
        ImageView ivItemMg = viewHolders.getId(R.id.iv_item_mg);
        if (isImView) {
            ivItemMg.setVisibility(View.GONE);
        } else {
            ivItemMg.setVisibility(View.VISIBLE);
            ivItemMg.setImageResource(integer);
        }
        TextView tvItemMg = viewHolders.getId(R.id.tv_item_mg);
        tvItemMg.setText(tabText.get(position));
        return viewHolders.convertView();
    }

}
