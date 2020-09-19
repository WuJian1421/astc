package com.example.astc.view.activity.mine;

import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatButton;

import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.BaseBean;
import com.example.astc.inter.contract.BaseContract;
import com.example.astc.inter.presenter.BasePresenter;
import com.example.astc.util.AppUtil;
import com.example.astc.util.views.ClearEditText;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;

/**
 * 修改登录密码
 * 2020-01-18
 *
 * @author
 */
public class ModifyLoginPasswordActivity extends BaseLazyActivity implements
        BaseContract.View<BaseBean> {

    @BindView(R.id.ev_login_password1)
    ClearEditText evLoginPassword1;
    @BindView(R.id.ev_login_password2)
    ClearEditText evLoginPassword2;
    @BindView(R.id.bu_login_password)
    AppCompatButton buLoginPassword;

    private BaseContract.Presenter presenter;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_login_password;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    @OnClick(R.id.bu_login_password)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(evLoginPassword1.getText().toString().trim())) {
            if (!TextUtils.isEmpty(evLoginPassword2.getText().toString().trim())) {
                presenter = new BasePresenter(this);
                presenter.methodCall();
            } else {
                ToastUtils.show(R.string.please_enter_new_password);
            }
        } else {
            ToastUtils.show(R.string.please_enter_old_password);
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
    public Call<BaseBean> setCall() {
        Applications applications = (Applications) getApplication();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("language", "0");
            jsonObject.put("oldPwd", AppUtil.md5(evLoginPassword1.getText().toString().trim()));
            jsonObject.put("newPwd", AppUtil.md5(evLoginPassword2.getText().toString().trim()));
            jsonObject.put("token", applications.getNewLoginBean().getToken());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Applications.getBasisProtocol().editPwd(jsonObject.toString());
    }

    /**
     * 接收数据
     *
     * @param baseBean
     */
    @Override
    public void getData(BaseBean baseBean) {
        ToastUtils.show(baseBean.getMessage());
    }
}
