package com.example.astc.view.activity;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.util.AppUtil;
import com.example.astc.util.views.BaseViewPagerView;
import com.example.astc.view.adapter.BaseFragmentAdapter;
import com.example.astc.view.fragment.importwallet.AccountNumberFragment;
import com.example.astc.view.fragment.importwallet.MnemonicFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import butterknife.BindView;

/**
 * 导入钱包
 * 2019-12-12
 *
 * @author
 */
public class ImportWalletActivity extends BaseLazyActivity implements
        ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.pv_import)
    BaseViewPagerView pvImport;
    @BindView(R.id.nv_import)
    BottomNavigationViewEx nvImport;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_import_wallet;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        //Tab
        pvImport.addOnPageChangeListener(this);
        BaseFragmentAdapter<BaseLazyFragment> adapter = new BaseFragmentAdapter<>(this);
        adapter.addFragment(new MnemonicFragment());
        adapter.addFragment(new AccountNumberFragment());
        pvImport.setAdapter(adapter);
        pvImport.setOffscreenPageLimit(adapter.getCount());
        AppUtil.setNoIcon(nvImport).setOnNavigationItemSelectedListener(this);
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                nvImport.setSelectedItemId(R.id.import_mnemonic);
                break;
            case 1:
                nvImport.setSelectedItemId(R.id.import_account_number);
                break;
            default:
                break;
        }
    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.import_mnemonic:
                pvImport.setCurrentItem(0);
                return true;
            case R.id.import_account_number:
                pvImport.setCurrentItem(1);
                return true;
            default:
                break;
        }
        return false;
    }
}
