package com.example.astc.view.fragment.main;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.inter.contract.BaseContract;
import com.example.astc.inter.presenter.BasePresenter;
import com.example.astc.util.views.ImageLoader;
import com.example.astc.view.activity.GuidePageActivity;
import com.example.astc.view.activity.home.PhotoActivity;
import com.example.astc.view.activity.mine.AboutUsActivity;
import com.example.astc.view.activity.mine.EnterpriseCertificationActivity;
import com.example.astc.view.activity.mine.IndividualCertificationActivity;
import com.example.astc.view.activity.mine.SystemSettingsActivity;
import com.example.astc.view.activity.mine.languageSettingActivity;
import com.example.astc.view.adapter.rv.MineRvAdapter;
import com.example.astc.view.dialog.BaseDialog;
import com.example.astc.view.dialog.InputDialog;
import com.example.astc.view.dialog.MenuDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;

/**
 * main-我的
 * 2019-12-20
 *
 * @author
 */
public class MineFragment extends BaseLazyFragment<MainActivity> implements
        BaseQuickAdapter.OnItemChildClickListener, BaseContract.View {

    @BindView(R.id.iv_id)
    TextView ivId;
    @BindView(R.id.iv_nickname)
    TextView ivNickname;
    @BindView(R.id.rv_mine)
    RecyclerView rvMine;
    @BindView(R.id.iv_user_avatar)
    AppCompatImageView ivUserAvatar;

    private String imgUrl;
    private Applications applications;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public boolean isStatusBarEnabled() {
        return !super.isStatusBarEnabled();
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        applications = (Applications) getAttachActivity().getApplication();
        if (applications.getNewLoginBean() != null) {
            ivId.setText(String.valueOf(applications.getNewLoginBean().getId()));
            ivNickname.setText(applications.getNewLoginBean().getNickname());
        }
        //头像

        //Rv
        MineRvAdapter mineRvAdapter = new MineRvAdapter(R.layout.item_rv_mine,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.rv_mine))),
                new ArrayList<>(Arrays.asList(R.mipmap.mine_system, R.mipmap.mine_language, R.mipmap.mine_personal,
                        R.mipmap.mine_enterprise, R.mipmap.mine_on, R.mipmap.mine_drop_out)));
        rvMine.setAdapter(mineRvAdapter);
        mineRvAdapter.setOnItemChildClickListener(this);
    }

    /**
     * callback method to be invoked when an item in this view has been
     * click and held
     *
     * @param adapter
     * @param view     The view whihin the ItemView that was clicked
     * @param position The position of the view int the adapter
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                //系统设置
                startActivity(SystemSettingsActivity.class);
                break;
            case 1:
                //语言设置
                startActivity(languageSettingActivity.class);
                break;
            case 2:
                //个人认证
                startActivity(IndividualCertificationActivity.class);
                break;
            case 3:
                //企业认证
                startActivity(EnterpriseCertificationActivity.class);
                break;
            case 4:
                //关于我们
                startActivity(AboutUsActivity.class);
                break;
            case 5:
                //退出钱包
                BaseContract.Presenter presenter = new BasePresenter(this);
                presenter.methodCall();
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.iv_user_avatar, R.id.iv_nickname})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_user_avatar:
                new MenuDialog.Builder(getActivity())
                        .setCancelable(false)
                        .setList(R.string.choose_a_photo)
                        .setListener(new MenuDialog.OnListener() {

                            @Override
                            public void onSelected(BaseDialog dialog, int position, Object object) {
                                PhotoActivity.start(getAttachActivity(), new PhotoActivity.OnPhotoSelectListener() {

                                    @Override
                                    public void onSelect(List<String> data) {
                                        imgUrl = data.get(0);
                                        ImageLoader.with(getActivity()).load(imgUrl).into(ivUserAvatar);
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
                break;
            case R.id.iv_nickname:
                new InputDialog.Builder(getActivity())
                        .setTitle(R.string.change_username)
                        .setListener(new InputDialog.OnListener() {

                            @Override
                            public void onConfirm(BaseDialog dialog, String content) {
                                ivNickname.setText(content);
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {

                            }
                        })
                        .show();
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

    }

    /**
     * 结束加载ing...
     */
    @Override
    public void endLoading() {

    }

    /**
     * 传递Call
     *
     * @return
     */
    @Override
    public Call setCall() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userNo", applications.getNewLoginBean().getId());
            jsonObject.put("language", "0");
            jsonObject.put("token", applications.getNewLoginBean().getToken());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Applications.getBasisProtocol().logout(jsonObject.toString());
    }

    /**
     * 接收数据
     *
     * @param o
     */
    @Override
    public void getData(Object o) {
        getAttachActivity().finish();
        Intent intent = new Intent(context, GuidePageActivity.class);
        intent.putExtra("verification", 1);
        startActivity(intent);
    }
}
