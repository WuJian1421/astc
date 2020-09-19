package com.example.astc.view.activity;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.views.SmartTextView;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.language.LanguagesManager;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGAGuideLinkageLayout;

/**
 * 引导图
 * 2020-01-06
 *
 * @author
 */
public class GuidePageActivity extends BaseLazyActivity {

    @BindView(R.id.bgaBanner)
    BGABanner bgaBanner;
    @BindView(R.id.btn_main)
    AppCompatButton btnMain;
    @BindView(R.id.bu_import)
    AppCompatButton buImport;
    @BindView(R.id.bu_create)
    AppCompatButton buCreate;
    @BindView(R.id.ll_enter)
    LinearLayout llEnter;
    @BindView(R.id.iv_welcome)
    AppCompatImageView ivWelcome;
    @BindView(R.id.fl_gpa)
    FrameLayout flGpa;
    @BindView(R.id.cl_guide)
    ConstraintLayout clGuide;
    @BindView(R.id.bgaGuide)
    BGAGuideLinkageLayout bgaGuide;
    @BindView(R.id.tv_welcome)
    SmartTextView tvWelcome;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide_page;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int verification = getIntent().getIntExtra("verification", 0);
        ImmersionBar.with(this).init();

        //判断用户进入
        SharedPreferences sharedPreferences = getSharedPreferences("is_first_in_data", MODE_PRIVATE);
        boolean isFirstIn = sharedPreferences.getBoolean("isFirstIn", true);
        if (isFirstIn) {
            // 设置数据源
            bgaBanner.setData(null, ImageView.ScaleType.CENTER_CROP,
                    R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3, R.mipmap.guide4, R.mipmap.guide5);
            bgaBanner.setEnterSkipViewIdAndDelegate(R.id.btn_main, 0, () -> {
                //写入引导页状态
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isFirstIn", false).apply();
                enterView();
            });
        } else {
            if (0 == verification) {
                flGpa.setVisibility(View.VISIBLE);
                getCountdown();
            } else {
                enterView();
            }
        }
        switch (sharedPreferences.getInt("language", 0)) {
            case 1:
                LanguagesManager.setAppLanguage(this, Locale.CHINA);
                break;
            case 2:
                LanguagesManager.setAppLanguage(this, Locale.ENGLISH);
                break;
            case 3:
                LanguagesManager.setAppLanguage(this, Locale.KOREA);
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.bu_import, R.id.bu_create, R.id.tv_welcome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bu_import:
                //导入钱包
                startActivity(ImportWalletActivity.class);
                break;
            case R.id.bu_create:
                //创建钱包
                startActivity(CreateWalletActivity.class);
                break;
            case R.id.tv_welcome:
                //启动页按钮
                flGpa.setVisibility(View.GONE);
                enterView();
                break;
            default:
                break;
        }
    }

    /**
     * 进入页
     */
    private void enterView() {
        bgaGuide.setVisibility(View.GONE);
        btnMain.setVisibility(View.GONE);
        clGuide.setBackgroundResource(R.mipmap.enter);
        llEnter.setVisibility(View.VISIBLE);
    }

    /**
     * 倒计时
     */
    private void getCountdown() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                //倒计时显示
                tvWelcome.setText(getString(R.string.jump_over) + l / 1000);
            }

            @Override
            public void onFinish() {
                //倒计时完成后
                flGpa.setVisibility(View.GONE);
                enterView();
            }
        };
        countDownTimer.start();
    }
}
