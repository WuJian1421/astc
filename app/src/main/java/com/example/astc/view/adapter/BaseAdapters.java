package com.example.astc.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用类Adapter
 * 2019-12-15
 *
 * @author
 */
public abstract class BaseAdapters<T> extends android.widget.BaseAdapter {
    private Activity activity;
    private Context context;
    private LayoutInflater layoutInflater;
    private List<T> data;

    public BaseAdapters(Context context, List<T> data) {
        super();
        setContext(context);
        setData(data);
        setLayoutInflater();
    }

    public BaseAdapters(Activity activity, List<T> data) {
        super();
        setActivity(activity);
        setData(data);
        setLayoutInflater();
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        setContext(activity);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context Parameter anomaly");
        }
        this.context = context;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public void setLayoutInflater() {
        if (context == null) {
            throw new RuntimeException("context Parameter anomaly");
        }
        layoutInflater = LayoutInflater.from(this.context);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        if (data == null) {
            data = new ArrayList<>();
        }
        this.data = data;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}