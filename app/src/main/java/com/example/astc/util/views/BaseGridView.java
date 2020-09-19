package com.example.astc.util.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 重写GridView
 * 2020-01-05
 *
 * @author
 */
public class BaseGridView extends GridView {

    public BaseGridView(Context context) {
        super(context);
    }

    public BaseGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}