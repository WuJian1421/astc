package com.example.astc.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.util.views.ClearEditText;
import com.hjq.toast.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 意见反馈-程序错误or产品建议
 * 2020-01-01
 *
 * @author
 */
public class ProgramErrorFragment extends BaseLazyFragment<MainActivity> {

    @BindView(R.id.tv_pe)
    AppCompatTextView tvPe;
    @BindView(R.id.et_pe)
    ClearEditText etPe;
    @BindView(R.id.tv_pe_cd)
    AppCompatTextView tvPeCd;
    @BindView(R.id.et_pe_cd)
    ClearEditText etPeCd;
    @BindView(R.id.bu_pe_cd)
    AppCompatButton buPeCd;
    private int type;

    public static ProgramErrorFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        ProgramErrorFragment fragment = new ProgramErrorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_program_error;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        type = getArguments().getInt("type", 0);
        switch (type) {
            case 0:
                //程序错误
                tvPe.setText(R.string.feedback_content);
                etPe.setHint(R.string.feedback_tips);
                break;
            case 1:
                //产品建议
                tvPe.setText(R.string.suggested_content);
                etPe.setHint(R.string.suggest_tips);
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.bu_pe_cd)
    public void onViewClicked() {
        //提交
        if (!TextUtils.isEmpty(etPe.getText().toString().trim())) {

        } else {
            if (0 == type) {
                ToastUtils.show(R.string.please_enter_feedback);
            } else {
                ToastUtils.show(R.string.please_enter_suggestions);
            }
        }
    }
}
