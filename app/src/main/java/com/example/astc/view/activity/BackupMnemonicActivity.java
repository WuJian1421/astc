package com.example.astc.view.activity;

import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.donkingliang.labels.LabelsView;
import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.AddUsersBean;
import com.example.astc.util.views.SmartTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 备份助记词
 * 2019-12-12
 *
 * @author
 */
public class BackupMnemonicActivity extends BaseLazyActivity implements
        LabelsView.OnLabelSelectChangeListener {

    @BindView(R.id.lv_backup)
    LabelsView lvBackup;
    @BindView(R.id.lv_show_backup)
    LabelsView lvShowBackup;
    @BindView(R.id.bu_backup)
    AppCompatButton buBackup;
    @BindView(R.id.tv_bm1)
    AppCompatTextView tvBm1;
    @BindView(R.id.tv_bm2)
    SmartTextView tvBm2;

    private AddUsersBean.DataBean dataBeans;
    private List<String> shows;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        //禁止截屏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        return R.layout.activity_backup_mnemonic;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        dataBeans = getIntent().getParcelableExtra("dataBean");
        shows = new ArrayList<>();
        //LabelsView
        lvShowBackup.setLabels(dataBeans.getMemo(), (label, position, data) -> data);
        lvShowBackup.setOnLabelSelectChangeListener(this);
    }

    /**
     * @param label    标签
     * @param data     标签对应的数据
     * @param isSelect 是否选中
     * @param position 标签位置
     */
    @Override
    public void onLabelSelectChange(TextView label, Object data, boolean isSelect, int position) {
        if (isSelect) {
            shows.add(label.getText().toString());
        } else {
            for (int i = 0; i < shows.size(); i++) {
                if (label.getText().toString().equals(shows.get(i))) {
                    shows.remove(shows.get(i));
                }
            }
        }
        lvBackup.setLabels(shows, (label1, position1, data1) -> data1);
        if (shows.size() == dataBeans.getMemo().size()) {
            tvBm1.setText(R.string.copy_mnemonic);
            tvBm2.setText(R.string.copy_mnemonic_tips);
        }
    }

    @OnClick(R.id.bu_backup)
    public void onViewClicked() {
        finish();
        startActivity(MainActivity.class);
    }
}
