package com.example.astc.view.activity.mine;

import android.content.SharedPreferences;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.hjq.language.LanguagesManager;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的-语言设置
 * 2020-01-01
 *
 * @author
 */
public class languageSettingActivity extends BaseLazyActivity {

    @BindView(R.id.item_bu_ls1)
    AppCompatButton itemBuLs1;
    @BindView(R.id.item_bu_ls2)
    AppCompatButton itemBuLs2;
    @BindView(R.id.item_bu_ls3)
    AppCompatButton itemBuLs3;

    private boolean restart;
    private int language = 0;
    private SharedPreferences sharedPreferences;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_language_settings;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        sharedPreferences = getSharedPreferences("is_first_in_data", MODE_PRIVATE);
        languageUi(sharedPreferences.getInt("language", 0));
    }

    @OnClick({R.id.item_bu_ls1, R.id.item_bu_ls2, R.id.item_bu_ls3})
    public void onViewClicked(View view) {
        Locale locale = null;
        switch (view.getId()) {
            case R.id.item_bu_ls1:
                //中文
                language = 1;
                locale = Locale.CHINA;
                break;
            case R.id.item_bu_ls2:
                //英文
                language = 2;
                locale = Locale.ENGLISH;
                break;
            case R.id.item_bu_ls3:
                //韩文
                language = 3;
                locale = Locale.KOREA;
                break;
            default:
                break;
        }
        restart = LanguagesManager.setAppLanguage(this, locale);
        languageUi(language);
    }

    /**
     * 根据状态改变按钮背景
     *
     * @param anInt
     */
    private void languageUi(int anInt) {
        switch (anInt) {
            case 1:
                itemBuLs1.setBackgroundResource(R.mipmap.bu_yellow);
                itemBuLs2.setBackgroundResource(R.mipmap.bu_white);
                itemBuLs3.setBackgroundResource(R.mipmap.bu_white);
                break;
            case 2:
                itemBuLs1.setBackgroundResource(R.mipmap.bu_white);
                itemBuLs2.setBackgroundResource(R.mipmap.bu_yellow);
                itemBuLs3.setBackgroundResource(R.mipmap.bu_white);
                break;
            case 3:
                //韩文
                itemBuLs1.setBackgroundResource(R.mipmap.bu_white);
                itemBuLs2.setBackgroundResource(R.mipmap.bu_white);
                itemBuLs3.setBackgroundResource(R.mipmap.bu_yellow);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        if (restart) {
            //写入设置语言
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("language", language).apply();

            //充分运用 Activity 跳转动画，在跳转的时候设置一个渐变的效果，相比前面的两种带来的体验是最佳的
            startActivity(languageSettingActivity.class);
            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }
}
