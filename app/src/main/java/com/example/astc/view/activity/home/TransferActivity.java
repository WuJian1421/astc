package com.example.astc.view.activity.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.view.dialog.BaseDialog;
import com.example.astc.view.dialog.MessageDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 转账
 * 2019-12-25
 *
 * @author
 */
public class TransferActivity extends BaseLazyActivity {

    @BindView(R.id.sp_transfer)
    AppCompatSpinner spTransfer;
    @BindView(R.id.bu_transfer)
    AppCompatButton buTransfer;
    @BindView(R.id.im_sweep_transfer)
    AppCompatImageView imSweepTransfer;
    @BindView(R.id.tv_transfer)
    AppCompatTextView tvTransfer;
    @BindView(R.id.tv_fast_transfer)
    AppCompatTextView tvFastTransfer;
    @BindView(R.id.tv_slow_transfer)
    AppCompatTextView tvSlowTransfer;
    @BindView(R.id.bar_transfer)
    SeekBar barTransfer;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_transfer;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        spTransfer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //选择列表项操作
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //未选择列表项操作
            }
        });
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
    }

    @OnClick({R.id.im_sweep_transfer, R.id.bu_transfer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_sweep_transfer:
                startActivity(ScanItActivity.class);
                break;
            case R.id.bu_transfer:
                String isTransfer = getString(R.string.successful_transfer);
                new MessageDialog.Builder(this)
                        .setMessage(isTransfer)
                        .setCancel(false)
                        .setListener(new MessageDialog.OnListener() {

                            @Override
                            public void onConfirm(BaseDialog dialog) {
                                dialog.dismiss();
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;
            default:
                break;
        }
    }
}
