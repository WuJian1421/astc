package com.example.astc.view.fragment.importwallet;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.donkingliang.labels.LabelsView;
import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.contract.MnemonicContract;
import com.example.astc.inter.presenter.MnemonicPresenter;
import com.example.astc.util.AppUtil;
import com.example.astc.util.Base64Util;
import com.example.astc.util.views.ClearEditText;
import com.example.astc.view.activity.ImportWalletActivity;
import com.example.astc.view.dialog.BaseDialog;
import com.example.astc.view.dialog.MessageDialog;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 助记词 Fragment
 * 2019-12-14
 *
 * @author
 */
public class MnemonicFragment extends BaseLazyFragment<ImportWalletActivity> implements
        MnemonicContract.View, LabelsView.OnLabelSelectChangeListener {

    @BindView(R.id.et_user_mnemonic)
    ClearEditText etUserMnemonic;
    @BindView(R.id.lv_mnemonic)
    LabelsView lvMnemonic;
    @BindView(R.id.lv_show_mnemonic)
    LabelsView lvShowMnemonic;
    @BindView(R.id.bu_fr_mnemonic)
    AppCompatButton buFrMnemonic;

    private MnemonicContract.Presenter mnemonicPresenter;
    private List<String> memoByBeans;
    private List<String> shows;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mnemonic;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        mnemonicPresenter = new MnemonicPresenter(this);
        memoByBeans = new ArrayList<>();
        shows = new ArrayList<>();
        etUserMnemonic.setText("Ceshi1234");
        lvShowMnemonic.setOnLabelSelectChangeListener(this);
    }

    @OnClick({R.id.lv_mnemonic, R.id.bu_fr_mnemonic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lv_mnemonic:
                if (AppUtil.iConnected(context)) {
                    if (memoByBeans.size() <= 0) {
                        new MessageDialog.Builder(getAttachActivity())
                                // 内容必须要填写
                                .setMessage(R.string.create_mnemonic_tips)
                                .setListener(new MessageDialog.OnListener() {

                                    @Override
                                    public void onConfirm(BaseDialog dialog) {
                                        dialog.dismiss();
                                        if (!TextUtils.isEmpty(etUserMnemonic.getText().toString().trim())) {
                                            mnemonicPresenter.methodCall();
                                        } else {
                                            ToastUtils.show(R.string.please_enter_user_name);
                                        }
                                    }

                                    @Override
                                    public void onCancel(BaseDialog dialog) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                } else {
                    ToastUtils.show(R.string.check_network_connection);
                }
                break;
            case R.id.bu_fr_mnemonic:
                if (AppUtil.iConnected(context)) {
                    if (!TextUtils.isEmpty(etUserMnemonic.getText().toString().trim())) {
                        if (memoByBeans.size() > 0) {
                            if (memoByBeans.size() == shows.size()) {
                                mnemonicPresenter.methodSubmitCall();
                            } else {
                                ToastUtils.show(getString(R.string.please_choose) + getString(R.string.mnemonic));
                            }
                        } else {
                            mnemonicPresenter.methodCall();
                        }
                    } else {
                        ToastUtils.show(getString(R.string.please_enter_user_name));
                    }
                } else {
                    ToastUtils.show(R.string.check_network_connection);
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
        String username = etUserMnemonic.getText().toString().trim();
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
        memoByBeans = getMemoByUserNameBean.getData().getMemo();
        //打乱list
//        Collections.shuffle(memoByBeans);
        lvShowMnemonic.setLabels(memoByBeans, (label, position, data) -> data);
    }

    /**
     * 传递
     *
     * @return
     */
    @Override
    public JSONObject getSubmitDataJson() {
        JSONObject jsonObject = new JSONObject();
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
        String md = "&memo=" + memo +
                "&timestamp=" + timestamp +
                Applications.accessKey;
        String sign = AppUtil.md5(md).toUpperCase();
        try {
            jsonObject.put("timestamp", timestamp);
            jsonObject.put("sign", sign);
            jsonObject.put("memo", memo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 接收数据
     *
     * @param newLoginBean
     */
    @Override
    public void getSubmitData(NewLoginBean newLoginBean) {
        if (Applications.NetworkingCode == newLoginBean.getCode()) {
            AppUtil.getAppNewLogin(getAttachActivity(), newLoginBean.getData());
            getAttachActivity().finish();
            startActivity(new Intent(context, MainActivity.class));
        } else {
            ToastUtils.show(getString(R.string.login_failed));
        }
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
        lvMnemonic.setLabels(shows, (label1, position1, data1) -> data1);
    }
}
