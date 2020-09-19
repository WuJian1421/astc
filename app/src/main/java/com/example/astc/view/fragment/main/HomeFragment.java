package com.example.astc.view.fragment.main;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.BaseDialogFragment;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.bean.GoldBean;
import com.example.astc.util.AppUtil;
import com.example.astc.util.views.BaseGridView;
import com.example.astc.util.views.GoldView;
import com.example.astc.view.activity.home.AccountActivity;
import com.example.astc.view.activity.home.NewsActivity;
import com.example.astc.view.activity.home.ScanItActivity;
import com.example.astc.view.activity.home.SearchForActivity;
import com.example.astc.view.activity.home.TokenActivity;
import com.example.astc.view.activity.home.TransferActivity;
import com.example.astc.view.adapter.BaseGridViewAdapter;
import com.example.astc.view.adapter.WealthBannerAdapter;
import com.hjq.toast.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

/**
 * main-首页
 * 2019-12-20
 *
 * @author
 */
public class HomeFragment extends BaseLazyFragment<MainActivity> implements
        AdapterView.OnItemClickListener {

    @BindView(R.id.item_et_sf)
    AppCompatEditText itemEtSf;
    @BindView(R.id.item_iv_home)
    AppCompatImageView itemIvHome;
    @BindView(R.id.gv_home)
    BaseGridView gvHome;
    @BindView(R.id.home_gold_view)
    GoldView homeGoldView;
    @BindView(R.id.banner_home_fr)
    Banner bannerHomeFr;

    private LinearLayout dialogLl;
    private AppCompatTextView dialogTvTitle;
    private AppCompatImageView dialogImBit;
    private Bitmap bitmapDialog;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
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
        //轮播图
        List<String> urls = new ArrayList<>();
        urls.add("");
        bannerHomeFr.setAdapter(new WealthBannerAdapter(urls, context));
        bannerHomeFr.setIndicator(new CircleIndicator(context));
        bannerHomeFr.setDelayTime(6000);
        bannerHomeFr.start();
        //宫格
        BaseGridViewAdapter baseGridViewAdapter = new BaseGridViewAdapter(context,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.gv_home))),
                new ArrayList<>(Arrays.asList(R.mipmap.scan_it, R.mipmap.collection, R.mipmap.transfer, R.mipmap.account,
                        R.mipmap.block_query, R.mipmap.invite_friends, R.mipmap.token, R.mipmap.more)));
        gvHome.setAdapter(baseGridViewAdapter);
        gvHome.setOnItemClickListener(this);
        //设置金币
        List<GoldBean> goldBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            goldBeans.add(new GoldBean((int) (i + Math.random() * 4), "item" + i));
        }
        homeGoldView.setWaters(goldBeans);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                //扫一扫
                startActivity(ScanItActivity.class);
                break;
            case 1:
                //收款
                View viewDialog = LayoutInflater.from(context).inflate(R.layout.dialog_custom, null);
                dialogTvTitle = viewDialog.findViewById(R.id.dialog_tv_title);
                dialogImBit = viewDialog.findViewById(R.id.dialog_im_bit);
                dialogImBit.setOnLongClickListener(view1 -> {
                    AppUtil.saveBitmap(context, bitmapDialog);
                    return false;
                });
                dialogLl = viewDialog.findViewById(R.id.dialog_ll);
                dialogLl.setOnClickListener(view1 -> {
                    // 获取系统剪贴板
                    ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText(null, dialogTvTitle.getText().toString().trim());
                    // 把数据集设置（复制）到剪贴板
                    clipboard.setPrimaryClip(clipData);
                    ToastUtils.show(R.string.copy_successful);
                });
                codeWithLogo(dialogTvTitle.getText().toString().trim());
                // 自定义对话框
                new BaseDialogFragment.Builder(getAttachActivity())
                        .setContentView(viewDialog)
                        .setOnClickListener(R.id.dialog_bu_collection, (dialog, view1) -> {
                            dialog.dismiss();
                            ToastUtils.show("设置");
                        })
                        .setOnClickListener(R.id.dialog_bu_ok, (dialog, view2) -> {
                            dialog.dismiss();
                            ToastUtils.show("确定");
                        })
                        .show();
                break;
            case 2:
                //转账
                startActivity(TransferActivity.class);
                break;
            case 3:
                //账户
                startActivity(AccountActivity.class);
                break;
            case 4:
                //区块查询
//                startActivity(BlockQueryActivity.class);
                ToastUtils.show(R.string.not_open_yet);
                break;
            case 5:
                //邀请好友
//                startActivity(InviteFriendsActivity.class);
                ToastUtils.show(R.string.not_open_yet);
                break;
            case 6:
                //通证
                startActivity(TokenActivity.class);
                break;
            case 7:
                //更多
                ToastUtils.show(R.string.not_open_yet);
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.item_et_sf, R.id.item_iv_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.item_et_sf:
                //搜索
                startActivity(SearchForActivity.class);
                break;
            case R.id.item_iv_home:
                //消息
                startActivity(NewsActivity.class);
                break;
            default:
                break;
        }
    }

    @SuppressLint("StaticFieldLeak")
    private void codeWithLogo(String s) {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap logoBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
                return QRCodeEncoder.syncEncodeQRCode(s, BGAQRCodeUtil.dp2px(context, 150), Color.BLACK, logoBitmap);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (AppUtil.isObject(bitmap)) {
                    bitmapDialog = bitmap;
                    dialogImBit.setImageBitmap(bitmap);
                } else {
                    ToastUtils.show("生成二维码失败");
                }
            }
        }.execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerHomeFr.stop();
    }
}
