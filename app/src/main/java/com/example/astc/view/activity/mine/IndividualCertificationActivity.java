package com.example.astc.view.activity.mine;

import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetIDCardBean;
import com.example.astc.inter.contract.IndividualCertificationContract;
import com.example.astc.util.views.ClearEditText;
import com.example.astc.util.views.ImageLoader;
import com.example.astc.view.activity.home.PhotoActivity;
import com.example.astc.view.dialog.BaseDialog;
import com.example.astc.view.dialog.MenuDialog;
import com.hjq.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的-个人认证
 * 2020-01-02
 *
 * @author
 */
public class IndividualCertificationActivity extends BaseLazyActivity implements
        IndividualCertificationContract.View {

    @BindView(R.id.sp_ic)
    AppCompatSpinner spIc;
    @BindView(R.id.et_username)
    ClearEditText etUsername;
    @BindView(R.id.et_number)
    ClearEditText etNumber;
    @BindView(R.id.iv_certificate1)
    AppCompatImageView ivCertificate1;
    @BindView(R.id.tv_certificate1)
    AppCompatTextView tvCertificate1;
    @BindView(R.id.iv_certificate2)
    AppCompatImageView ivCertificate2;
    @BindView(R.id.tv_certificate2)
    AppCompatTextView tvCertificate2;
    @BindView(R.id.iv_certificate3)
    AppCompatImageView ivCertificate3;
    @BindView(R.id.iv_certificate4)
    AppCompatImageView ivCertificate4;
    @BindView(R.id.ll_certificate4)
    LinearLayout llCertificate4;
    @BindView(R.id.bu_ic)
    AppCompatButton buIc;
    @BindView(R.id.cv_ec)
    AppCompatButton cvEc;

    private View includeIc;
    private String imgUrl1, imgUrl2, imgUrl3;
    private IndividualCertificationContract.Presenter presenter;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_individual_certification;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
//        presenter = new IndividualCertificationPresenter(this);
//        presenter.methodCall();
        includeIc = findViewById(R.id.include_ic);
        //Sp
        spIc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        //身份证
                        break;
                    case 1:
                        //护照
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //布局
        tvCertificate1.setText(R.string.upload_your_front_photo);
        tvCertificate2.setText(R.string.upload_negative_photo);
        llCertificate4.setVisibility(View.INVISIBLE);
        etNumber.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
    }

    @OnClick({R.id.iv_certificate1, R.id.iv_certificate2, R.id.iv_certificate3, R.id.bu_ic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_certificate1:
                getMenuDialog(1);
                break;
            case R.id.iv_certificate2:
                getMenuDialog(2);
                break;
            case R.id.iv_certificate3:
                getMenuDialog(3);
                break;
            case R.id.bu_ic:
                if (!TextUtils.isEmpty(etUsername.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(etNumber.getText().toString().trim())) {
                        if (!TextUtils.isEmpty(imgUrl1) & !TextUtils.isEmpty(imgUrl2) &
                                !TextUtils.isEmpty(imgUrl3)) {
                            //请求数据

                        } else {
                            ToastUtils.show(R.string.please_upload_a_full_photo);
                        }
                    } else {
                        ToastUtils.show(R.string.please_enter_your_id_number);
                    }
                } else {
                    ToastUtils.show(R.string.please_enter_your_certificate_name);
                }
                break;
            default:
                break;
        }
    }

    private void getMenuDialog(int type) {
        new MenuDialog.Builder(this)
                .setCancelable(false)
                .setList(R.string.choose_a_photo)
                .setListener(new MenuDialog.OnListener() {

                    @Override
                    public void onSelected(BaseDialog dialog, int position, Object object) {
                        PhotoActivity.start(getActivity(), new PhotoActivity.OnPhotoSelectListener() {

                            @Override
                            public void onSelect(List<String> data) {
                                switch (type) {
                                    case 1:
                                        imgUrl1 = data.get(0);
                                        ivCertificate1.setBackgroundResource(0);
                                        ImageLoader.with(context).load(data.get(0)).into(ivCertificate1);
                                        break;
                                    case 2:
                                        imgUrl2 = data.get(0);
                                        ivCertificate2.setBackgroundResource(0);
                                        ImageLoader.with(context).load(data.get(0)).into(ivCertificate2);
                                        break;
                                    case 3:
                                        imgUrl3 = data.get(0);
                                        ivCertificate3.setBackgroundResource(0);
                                        ImageLoader.with(context).load(data.get(0)).into(ivCertificate3);
                                        break;
                                    default:
                                        break;
                                }
                            }

                            @Override
                            public void onCancel() {

                            }
                        });
                    }

                    @Override
                    public void onCancel(BaseDialog dialog) {
                    }
                })
                .show();
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
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("language", "0");
            jsonObject.put("token", applications.getNewLoginBean().getToken());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 接收数据
     *
     * @param getIDCardBean
     */
    @Override
    public void getData(GetIDCardBean getIDCardBean) {
        //0：审核中 1：通过
        String certification = getIDCardBean.getData().getState();
        //状态
        switch (certification) {
            case "0":
                cvEc.setVisibility(View.VISIBLE);
                cvEc.setText(R.string.under_review);
                break;
            case "1":
                //已通过
                etUsername.setText(getIDCardBean.getData().getName());
                etUsername.setFocusable(false);
                etNumber.setText(getIDCardBean.getData().getIdCardNumber());
                etNumber.setFocusable(false);
                cvEc.setVisibility(View.VISIBLE);
                cvEc.setText(R.string.passed);
                includeIc.setVisibility(View.GONE);
                buIc.setVisibility(View.GONE);
                break;
            default:
                cvEc.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 传递
     *
     * @return
     */
    @Override
    public JSONObject getSubmitDataJson() {
        return null;
    }

    /**
     * 接收数据
     *
     * @param baseBean
     */
    @Override
    public void getSubmitData(BaseBean baseBean) {

    }
}
