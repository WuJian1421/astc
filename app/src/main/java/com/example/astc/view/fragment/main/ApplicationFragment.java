package com.example.astc.view.fragment.main;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.astc.MainActivity;
import com.example.astc.R;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.util.AppUtil;
import com.example.astc.util.views.BaseViewPagerView;
import com.example.astc.view.adapter.BaseFragmentAdapter;
import com.example.astc.view.adapter.WealthBannerAdapter;
import com.example.astc.view.fragment.DomesticServicesFragment;
import com.example.astc.view.fragment.GameEntertainmentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * main-应用
 * 2019-12-20
 *
 * @author
 */
public class ApplicationFragment extends BaseLazyFragment<MainActivity> implements
        ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.pv_application)
    BaseViewPagerView pvApplication;
    @BindView(R.id.nv_application)
    BottomNavigationViewEx nvApplication;
    @BindView(R.id.banner_application_fr)
    Banner bannerApplicationFr;

    /**
     * 引入布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_application;
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
        //Banner
        List<String> urls = new ArrayList<>();
        urls.add("");
        bannerApplicationFr.setAdapter(new WealthBannerAdapter(urls, context));
        bannerApplicationFr.setIndicator(new CircleIndicator(context));
        bannerApplicationFr.setDelayTime(6000);
        bannerApplicationFr.start();
        //Tab
        pvApplication.addOnPageChangeListener(this);
        AppUtil.setNoIcon(nvApplication).setOnNavigationItemSelectedListener(this);
        BaseFragmentAdapter<BaseLazyFragment> adapter = new BaseFragmentAdapter<>(this);
        adapter.addFragment(new DomesticServicesFragment());
        adapter.addFragment(new GameEntertainmentFragment());
        pvApplication.setAdapter(adapter);
        pvApplication.setOffscreenPageLimit(adapter.getCount());
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
                nvApplication.setSelectedItemId(R.id.application_domestic_services);
                break;
            case 1:
                nvApplication.setSelectedItemId(R.id.application_game_entertainment);
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
            case R.id.application_domestic_services:
                pvApplication.setCurrentItem(0);
                return true;
            case R.id.application_game_entertainment:
                pvApplication.setCurrentItem(1);
                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerApplicationFr.stop();
    }
}