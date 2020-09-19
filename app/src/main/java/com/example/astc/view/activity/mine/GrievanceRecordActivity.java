package com.example.astc.view.activity.mine;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;

import butterknife.BindView;

/**
 * 申诉记录
 * 2020-01-04
 *
 * @author
 */
public class GrievanceRecordActivity extends BaseLazyActivity {

    @BindView(R.id.rv_grievance)
    RecyclerView rvGrievance;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_grievance_record;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {

    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        startActivity(FillInTheAppealActivity.class);
    }
}
