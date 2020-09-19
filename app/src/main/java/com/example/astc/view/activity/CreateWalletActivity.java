package com.example.astc.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.AddUsersBean;
import com.example.astc.inter.contract.BaseContract;
import com.example.astc.util.AppUtil;
import com.example.astc.util.views.ClearEditText;
import com.example.astc.util.views.PasswordEditText;
import com.example.astc.util.views.SmartTextView;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * 创建钱包
 * 2019-12-12
 *
 * @author
 */
public class CreateWalletActivity extends BaseLazyActivity implements
        BaseContract.View<AddUsersBean> {

    @BindView(R.id.et1_user_cw)
    ClearEditText et1UserCw;
    @BindView(R.id.et2_pw_cw)
    PasswordEditText et2PwCw;
    @BindView(R.id.et3_ps_tips_cw)
    PasswordEditText et3PsTipsCw;
    @BindView(R.id.et4_referee_cw)
    ClearEditText et4RefereeCw;
    @BindView(R.id.cb_create)
    AppCompatCheckBox cbCreate;
    @BindView(R.id.tv_pp)
    SmartTextView tvPp;
    @BindView(R.id.ll_create)
    LinearLayout llCreate;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.bu_f_cw)
    AppCompatButton buFCw;

    private BaseContract.Presenter basePresenter;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_wallet;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        et1UserCw.setText("zhangsan");
        et2PwCw.setText("12345");
        et3PsTipsCw.setText("12345");
        et4RefereeCw.setText("zouping1024");

        //条款
        String tips = getString(R.string.service_tips);
        SpannableString sanest = new SpannableString(tips);
        sanest.setSpan(new TextClick(), 0, tips.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvPp.setText(getString(R.string.privacy_policy));
        tvPp.append(sanest);
        tvPp.setMovementMethod(LinkMovementMethod.getInstance());
        tvPp.setHighlightColor(Color.TRANSPARENT);
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
    public Call<AddUsersBean> setCall() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", et1UserCw.getText().toString());
            jsonObject.put("dealPwd", et2PwCw.getText().toString());
            jsonObject.put("referee", et4RefereeCw.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return AppUtil.getProtocolTest().addUsers
                (RequestBody.create(AppUtil.getMediaType(), jsonObject.toString()));
    }

    /**
     * 接收数据
     *
     * @param addUsersBean
     */
    @Override
    public void getData(AddUsersBean addUsersBean) {
        Intent intent = new Intent(context, BackupMnemonicActivity.class);
        intent.putExtra("dataBean", addUsersBean.getData());
        startActivity(intent);
    }

    @OnClick(R.id.bu_f_cw)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(et1UserCw.getText().toString().trim())) {
            if (!TextUtils.isEmpty(et2PwCw.getText().toString())) {
                if (!TextUtils.isEmpty(et3PsTipsCw.getText().toString().trim())) {
                    if (et2PwCw.getText().toString().trim().equals
                            (et3PsTipsCw.getText().toString().trim())) {
                        if (!TextUtils.isEmpty(et4RefereeCw.getText().toString().trim())) {
                            if (cbCreate.isChecked()) {
//                                basePresenter = new BasePresenter(this);
//                                basePresenter.methodCall();

                                AddUsersBean.DataBean dataBean = new AddUsersBean.DataBean();
                                dataBean.setMemo(Arrays.asList("1", "2", "3"));
                                Intent intent = new Intent(context, BackupMnemonicActivity.class);
                                startActivity(intent.putExtra("dataBean", dataBean));
                            } else {
                                ToastUtils.show(getString(R.string.please_agree) + getString(R.string.service_tips));
                            }
                        } else {
                            ToastUtils.show(getString(R.string.please_enter) + getString(R.string.recommended_users_prompt));
                        }
                    } else {
                        ToastUtils.show(getString(R.string.inconsistent_passwords));
                    }
                } else {
                    ToastUtils.show(getString(R.string.ok_password_prompt));
                }
            } else {
                ToastUtils.show(getString(R.string.password_prompt));
            }
        } else {
            ToastUtils.show(getString(R.string.please_enter_user_name));
        }
    }

    /**
     * 颜色文字点击事件
     */
    public class TextClick extends ClickableSpan {

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(getResources().getColor(R.color.yellow));
        }

        @Override
        public void onClick(View widget) {
            //服务条款
            startActivity(ServiceTipsActivity.class);
        }
    }
}
