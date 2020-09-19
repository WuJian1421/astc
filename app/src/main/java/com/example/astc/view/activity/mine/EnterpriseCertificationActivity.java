package com.example.astc.view.activity.mine;

import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.views.ClearEditText;
import com.example.astc.util.views.ImageLoader;
import com.example.astc.view.activity.home.PhotoActivity;
import com.example.astc.view.dialog.BaseDialog;
import com.example.astc.view.dialog.MenuDialog;
import com.hjq.toast.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的-企业认证
 * 2020-01-01
 *
 * @author
 */
public class EnterpriseCertificationActivity extends BaseLazyActivity {

    @BindView(R.id.et_ec1)
    ClearEditText etEc1;
    @BindView(R.id.et_ec2)
    ClearEditText etEc2;
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
    @BindView(R.id.bu_ec)
    AppCompatButton buEc;
    @BindView(R.id.cv_ec)
    AppCompatButton cvEc;

    private String imgUrl1, imgUrl2, imgUrl3, imgUrl4;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_enterprise_certification;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        //布局
        tvCertificate1.setText(R.string.upload_a_positive_photo_of_the_corporate_identity_document);
        tvCertificate2.setText(R.string.upload_a_negative_photo_of_your_corporate_id);
        etEc2.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
    }

//     <string name="under_review">审核中</string>
//    <string name="passed">已通过</string>

    @OnClick({R.id.iv_certificate1, R.id.iv_certificate2, R.id.iv_certificate3, R.id.iv_certificate4, R.id.bu_ec})
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
            case R.id.iv_certificate4:
                getMenuDialog(4);
                break;
            case R.id.bu_ec:
                if (!TextUtils.isEmpty(etEc1.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(etEc2.getText().toString().trim())) {
                        if (!TextUtils.isEmpty(imgUrl1) & !TextUtils.isEmpty(imgUrl2) &
                                !TextUtils.isEmpty(imgUrl3) & !TextUtils.isEmpty(imgUrl4)) {
                            //请求数据

                        } else {
                            ToastUtils.show(R.string.please_upload_a_full_photo);
                        }
                    } else {
                        ToastUtils.show(R.string.please_enter_your_id_number);
                    }
                } else {
                    ToastUtils.show(R.string.please_enter_the_corporate_name);
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
                                    case 4:
                                        imgUrl4 = data.get(0);
                                        ivCertificate4.setBackgroundResource(0);
                                        ImageLoader.with(context).load(data.get(0)).into(ivCertificate4);
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

}
