package com.example.astc.view.activity.home;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.GetBalanceBean;
import com.example.astc.bean.NewLoginBean;
import com.example.astc.inter.contract.BaseContract;
import com.example.astc.inter.presenter.BasePresenter;
import com.example.astc.view.adapter.rv.AccountAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import retrofit2.Call;

/**
 * 账户
 * 2019-12-25
 *
 * @author
 */
public class AccountActivity extends BaseLazyActivity implements
        BaseContract.View<GetBalanceBean> {

    @BindView(R.id.rv_account)
    RecyclerView rvAccount;
    @BindView(R.id.iv_add_account)
    AppCompatImageView ivAddAccount;
    private BaseContract.Presenter presenter;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_account;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        presenter = new BasePresenter(this);
        presenter.methodCall();
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
    public Call<GetBalanceBean> setCall() {
        Applications application = (Applications) getApplication();
        NewLoginBean.DataBean dataBean = application.getNewLoginBean();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("language", "0");
            jsonObject.put("token", dataBean.getToken());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Applications.getBasisProtocol().getBalance(jsonObject.toString());
    }

    /**
     * 接收数据
     *
     * @param getBalanceBean
     */
    @Override
    public void getData(GetBalanceBean getBalanceBean) {
        AccountAdapter accountAdapter = new AccountAdapter(R.layout.item_rv_account,
                getBalanceBean.getData().getUserWallets());
        rvAccount.setAdapter(accountAdapter);
    }
}
