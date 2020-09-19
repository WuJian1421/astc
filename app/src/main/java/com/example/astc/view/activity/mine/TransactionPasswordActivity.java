package com.example.astc.view.activity.mine;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.donkingliang.labels.LabelsView;
import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.inter.contract.TransactionPasswordContract;
import com.example.astc.inter.presenter.TransactionPasswordPresenter;
import com.example.astc.util.AppUtil;
import com.example.astc.util.Base64Util;
import com.example.astc.util.views.ClearEditText;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 系统设置-设置/修改交易密码
 * 2020-01-04
 *
 * @author
 */
public class TransactionPasswordActivity extends BaseLazyActivity implements
        TransactionPasswordContract.View, LabelsView.OnLabelSelectChangeListener {

    @BindView(R.id.tv_tp)
    AppCompatTextView tvTp;
    @BindView(R.id.lv_password)
    LabelsView lvPassword;
    @BindView(R.id.lv_show_password)
    LabelsView lvShowPassword;
    @BindView(R.id.ev_password1)
    ClearEditText evPassword1;
    @BindView(R.id.ev_password2)
    ClearEditText evPassword2;
    @BindView(R.id.bu_password)
    AppCompatButton buCtPassword;

    private List<String> memoByBeans;
    private List<String> shows;
    private TransactionPasswordContract.Presenter presenter;
    /**
     * 0：设置
     * 1：修改
     */
    private int type;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        type = getIntent().getIntExtra("type", 1);
        return R.layout.activity_transaction_password;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        presenter = new TransactionPasswordPresenter(this);
        presenter.methodCall();
        switch (type) {
            case 0:
                //设置交易密码
                setTitle(R.string.set_transaction_password);
                buCtPassword.setText(R.string.save);
                break;
            case 1:
                //修改交易密码
                setTitle(R.string.change_transaction_password);
                buCtPassword.setText(R.string.confirm_modify);
                break;
            default:
                break;
        }
        shows = new ArrayList<>();
    }

    @OnClick({R.id.bu_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bu_password:
                //提交密码
                if (!TextUtils.isEmpty(evPassword1.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(evPassword2.getText().toString().trim())) {
                        if (evPassword2.getText().toString().trim().equals
                                (evPassword1.getText().toString().trim())) {
                            //修改交易密码
                            presenter.methodSubmitCall();
                        } else {
                            ToastUtils.show(R.string.inconsistent_passwords);
                        }
                    } else {
                        ToastUtils.show(R.string.ok_password_prompt);
                    }
                } else {
                    ToastUtils.show(getString(R.string.please_enter) + getString(R.string.new_transaction_password));
                }
                break;
            default:
                break;
        }
    }

    /**
     * 运行加载ing...
     */
    @Override
    public void startLoading() {
        showLoading();
    }

    /**
     * 结束加载ing...
     */
    @Override
    public void endLoading() {
        showComplete();
    }

    /**
     * 传递
     *
     * @return
     */
    @Override
    public JSONObject getDataJson() {
        Applications applications = (Applications) getApplication();
        String username = applications.getNewLoginBean().getUsername();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String md = "&timestamp=" + timestamp +
                "&userName=" + username +
                Applications.accessKey;
        String sign = AppUtil.md5(md).toUpperCase();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userName", username);
            jsonObject.put("timestamp", timestamp);
            jsonObject.put("sign", sign);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 接收数据
     *
     * @param getMemoByUserNameBean
     */
    @Override
    public void getData(GetMemoByUserNameBean getMemoByUserNameBean) {
        memoByBeans = new ArrayList<>();
        memoByBeans = getMemoByUserNameBean.getData().getMemo();
        //打乱list
        Collections.shuffle(memoByBeans);
        lvShowPassword.setLabels(memoByBeans, (label, position, data) -> data);
        lvShowPassword.setOnLabelSelectChangeListener(this);
    }

    /**
     * 传递
     *
     * @return
     */
    @Override
    public JSONObject getPasswordJson() {
        String dealPwd = AppUtil.md5(evPassword1.getText().toString().trim());
        String timestamp = String.valueOf(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < shows.size(); i++) {
            try {
                if (i == shows.size() - 1) {
                    stringBuilder.append(shows.get(i));
                } else {
                    stringBuilder.append(shows.get(i) + " ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String memo = "";
        try {
            memo = Base64Util.TDES(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String md = "&dealPwd=" + dealPwd +
                "&memo=" + memo +
                "&timestamp=" + timestamp +
                Applications.accessKey;
        String sign = AppUtil.md5(md).toUpperCase();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("dealPwd", dealPwd);
            jsonObject.put("language", "0");
            jsonObject.put("memo", memo);
            jsonObject.put("timestamp", timestamp);
            jsonObject.put("sign", sign);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 接收数据
     *
     * @param baseBean
     */
    @Override
    public void getTransactionPassword(BaseBean baseBean) {
        ToastUtils.show(R.string.successfully_modified);
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
        lvPassword.setLabels(shows, (label1, position1, data1) -> data1);
    }
}