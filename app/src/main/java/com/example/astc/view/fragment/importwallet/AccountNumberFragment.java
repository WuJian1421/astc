package com.example.astc.view.fragment.importwallet;

import android.content.Intent;
import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatButton;

import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.contract.BaseContract;
import com.example.astc.inter.presenter.BasePresenter;
import com.example.astc.util.AppUtil;
import com.example.astc.util.views.ClearEditText;
import com.example.astc.util.views.PasswordEditText;
import com.example.astc.view.activity.ImportWalletActivity;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * 账号Fragment
 * 2019-12-14
 *
 * @author
 */
public class AccountNumberFragment extends BaseLazyFragment<ImportWalletActivity> implements
        BaseContract.View<NewLoginBean> {

    @BindView(R.id.et_user_account)
    ClearEditText etUserAccount;
    @BindView(R.id.et_password_account)
    PasswordEditText etPasswordAccount;
    @BindView(R.id.bu_account)
    AppCompatButton buAccount;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account_numbe;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        etUserAccount.setText("zhangsan123");
        etPasswordAccount.setText("123456");
    }

    @OnClick(R.id.bu_account)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(etUserAccount.getText().toString().trim())) {
            if (!TextUtils.isEmpty(etPasswordAccount.getText().toString().trim())) {
                if (AppUtil.iConnected(context)) {
                    BaseContract.Presenter presenter = new BasePresenter(this);
                    presenter.methodCall();
                } else {
                    ToastUtils.show(R.string.check_network_connection);
                }
            } else {
                ToastUtils.show(getString(R.string.please_enter_your_password));
            }
        } else {
            ToastUtils.show(getString(R.string.please_enter_user_name));
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
     * 传递Call
     *
     * @return
     */
    @Override
    public Call<NewLoginBean> setCall() {
        String username = etUserAccount.getText().toString().trim();
        String password = AppUtil.md5(etPasswordAccount.getText().toString().trim());
        String timestamp = String.valueOf(System.currentTimeMillis());
        String md = "&password=" + password +
                "&timestamp=" + timestamp +
                "&username=" + username +
                Applications.accessKey;
        String sign = AppUtil.md5(md).toUpperCase();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
            jsonObject.put("timestamp", timestamp);
            jsonObject.put("sign", sign);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Applications.getBasisProtocol()
                .newlogin(RequestBody.create(AppUtil.getMediaType(), jsonObject.toString()));
    }

    /**
     * 接收数据
     *
     * @param newLoginBean
     */
    @Override
    public void getData(NewLoginBean newLoginBean) {
        if (Applications.NetworkingCode == newLoginBean.getCode()) {
            AppUtil.getAppNewLogin(getAttachActivity(), newLoginBean.getData());
            getAttachActivity().finish();
            startActivity(new Intent(context, MainActivity.class));
        } else {
            ToastUtils.show(newLoginBean.getMessage());
        }
    }
}