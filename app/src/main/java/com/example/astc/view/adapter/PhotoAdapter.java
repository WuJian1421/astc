package com.example.astc.view.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.example.astc.util.views.ImageLoader;

import java.util.List;

import butterknife.BindView;

/**
 * 图片选择适配器
 * 2020-01-06
 *
 * @author
 */
public final class PhotoAdapter extends MyRecyclerViewAdapter<String> {

    private final List<String> mSelectPhoto;

    public PhotoAdapter(Context context, List<String> data) {
        super(context);
        mSelectPhoto = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    @Override
    protected RecyclerView.LayoutManager getDefaultLayoutManager(Context context) {
        return new GridLayoutManager(context, 3);
    }

    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.iv_photo_image)
        ImageView mImageView;
        @BindView(R.id.iv_photo_check)
        CheckBox mCheckBox;

        ViewHolder() {
            super(R.layout.item_photo);
        }

        @Override
        public void onBindView(int position) {
            ImageLoader.with(getContext()).load(getItem(position)).into(mImageView);
            mCheckBox.setChecked(mSelectPhoto.contains(getItem(position)));
        }
    }
}