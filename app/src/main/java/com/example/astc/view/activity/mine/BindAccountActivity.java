package com.example.astc.view.activity.mine;

import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.BaseBean;
import com.example.astc.inter.contract.BindAccountContract;
import com.example.astc.inter.presenter.BindAccountPresenter;
import com.example.astc.util.views.ClearEditText;
import com.example.astc.util.views.ImageLoader;
import com.example.astc.view.activity.home.PhotoActivity;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;

/**
 * 绑定账号（1：支付宝 2：微信）
 * 2020-01-08
 *
 * @author
 */
public class BindAccountActivity extends BaseLazyActivity implements
        BindAccountContract.View<BaseBean> {

    @BindView(R.id.et_account)
    ClearEditText etAccount;
    @BindView(R.id.iv_bind_account)
    AppCompatImageView ivBindAccount;
    @BindView(R.id.bu_bind_account)
    AppCompatButton buBindAccount;
    @BindView(R.id.et_transaction_password)
    ClearEditText etTransactionPassword;

    private int account;
    private String imgFile;
    private BindAccountContract.Presenter presenter;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_account;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        account = getIntent().getIntExtra("account", 0);
        switch (account) {
            case 0:
                //绑定支付宝
                setTitle(R.string.pay_ali_pay_account);
                etAccount.setHint(R.string.please_fill_in_alipay_account);
                etAccount.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                break;
            case 1:
                //绑定微信
                setTitle(R.string.pay_we_chat_account);
                etAccount.setHint(R.string.please_fill_in_wechat_account);
                etAccount.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            default:
                break;
        }
        etTransactionPassword.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
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
     * 传递Call
     *
     * @return
     */
    @Override
    public Call<BaseBean> setCall() {
//        {
//            "dealPwd":"21218cca77804d2ba1922c33e0151105",
//                "weChat":"13714524982",
//                "language":"0",
//                "token":"625f49b9bd534d1194bbb093be5969aa"
//        }
        Applications applications = (Applications) getApplication();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("dealPwd", etTransactionPassword.getText().toString().trim());
            jsonObject.put("language", "0");
            jsonObject.put("token", applications.getNewLoginBean().getToken());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<BaseBean> baseBeanCall = null;
        switch (account) {
            case 0:
                //支付宝
                try {
                    jsonObject.put("alipay", etAccount.getText().toString().trim());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                baseBeanCall = Applications.getBasisProtocol().bindApay
                        (jsonObject.toString(), "");
                break;
            case 1:
                //微信
                try {
                    jsonObject.put("weChat", etAccount.getText().toString().trim());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                baseBeanCall = Applications.getBasisProtocol().bindWeChat
                        (jsonObject.toString(), "");
                break;
            default:
                break;
        }
        return baseBeanCall;
    }

    /**
     * 接收数据
     *
     * @param baseBean
     */
    @Override
    public void getData(BaseBean baseBean) {

    }

    @OnClick({R.id.iv_bind_account, R.id.bu_bind_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_bind_account:
                PhotoActivity.start(getActivity(), new PhotoActivity.OnPhotoSelectListener() {

                    @Override
                    public void onSelect(List<String> data) {
                        imgFile = data.get(0);
                        ivBindAccount.setBackgroundResource(0);
                        ImageLoader.with(getActivity()).load(imgFile).into(ivBindAccount);
                        Log.d("TAG", "----->" + "图片路径：" + imgFile);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                break;
            case R.id.bu_bind_account:
                if (!TextUtils.isEmpty(etAccount.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(etTransactionPassword.getText().toString().trim())) {
                        presenter = new BindAccountPresenter(this);
                        presenter.methodCall();
                    } else {
                        ToastUtils.show(R.string.please_enter_transaction_password);
                    }
                } else {
                    if (0 == account) {
                        ToastUtils.show(R.string.please_fill_in_alipay_account);
                    } else {
                        ToastUtils.show(R.string.please_fill_in_wechat_account);
                    }
                }
                break;
            default:
                break;
        }
    }
}
