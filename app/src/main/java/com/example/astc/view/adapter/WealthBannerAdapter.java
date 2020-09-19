package com.example.astc.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * Banner适配器
 * 2020-02-12
 *
 * @author
 */
public class WealthBannerAdapter extends BannerAdapter<String, WealthBannerAdapter.ImageHolder> {

    private Context context;
    private int[] images = {R.mipmap.ceshi1};

    public WealthBannerAdapter(List<String> datas, Context context) {
        super(datas);
        this.context = context;
    }

    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return XViewHolder
     */
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageHolder(imageView);
    }

    /**
     * 绑定布局数据
     *
     * @param holder   XViewHolder
     * @param data     数据实体
     * @param position 当前位置
     * @param size     总数
     */
    @Override
    public void onBindView(ImageHolder holder, String data, int position, int size) {
//        if (AppUtil.iConnected(context)) {
//            //使用网络
//            Glide.with(holder.itemView).load(data).into(holder.imageView);
//        } else {
            //使用本地
            holder.imageView.setImageResource(images[position]);
//        }
    }

    static class ImageHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ImageHolder(@NonNull View view) {
            super(view);
            this.imageView = (ImageView) view;
        }
    }
}
