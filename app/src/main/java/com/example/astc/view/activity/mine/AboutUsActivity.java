package com.example.astc.view.activity.mine;

import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.BuildConfig;
import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.view.activity.about.FeedbackActivity;
import com.example.astc.view.adapter.rv.AboutUsAdapter;
import com.example.astc.view.dialog.UpdateDialog;
import com.hjq.toast.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

/**
 * 我的-关于我们
 * 2019-12-29
 *
 * @author
 */
public class AboutUsActivity extends BaseLazyActivity {

    @BindView(R.id.rv_au)
    RecyclerView rvAu;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_us;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        //Rv
        AboutUsAdapter aboutUsAdapter = new AboutUsAdapter(R.layout.item_rv_aboutus,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.rv_about_us))));
        rvAu.setAdapter(aboutUsAdapter);
        aboutUsAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (position) {
                case 0:
                    //当前版本
                    break;
                case 1:
                    //新版本更新
                    if (2 > BuildConfig.VERSION_CODE) {
                        new UpdateDialog.Builder(this)
                                // 版本名
                                .setVersionName("v 2.0")
                                // 文件大小
                                .setFileSize("10 M")
                                // 是否强制更新
                                .setForceUpdate(false)
                                // 更新日志
                                .setUpdateLog("到底更新了啥\n到底更新了啥\n到底更新了啥\n到底更新了啥\n到底更新了啥")
                                // 下载 url
                                .setDownloadUrl("")
                                .show();
                    } else {
                        ToastUtils.show(R.string.update_no_update);
                    }
                    break;
                case 2:
                    //意见反馈
                    startActivity(FeedbackActivity.class);
                    break;
                case 3:
                    //申诉记录
                    startActivity(GrievanceRecordActivity.class);
                    break;
                default:
                    break;
            }
        });
    }

}
