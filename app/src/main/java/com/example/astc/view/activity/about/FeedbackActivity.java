package com.example.astc.view.activity.about;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.util.AppUtil;
import com.example.astc.util.views.BaseViewPagerView;
import com.example.astc.view.adapter.BaseFragmentAdapter;
import com.example.astc.view.fragment.ProgramErrorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import butterknife.BindView;

/**
 * 意见反馈
 * 2019-12-31
 *
 * @author
 */
public class FeedbackActivity extends BaseLazyActivity implements ViewPager.OnPageChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nv_feedback)
    BottomNavigationViewEx nvFeedback;
    @BindView(R.id.pv_feedback)
    BaseViewPagerView pvFeedback;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        //Tab
        pvFeedback.addOnPageChangeListener(this);
        AppUtil.setNoIcon(nvFeedback).setOnNavigationItemSelectedListener(this);
        BaseFragmentAdapter<BaseLazyFragment> adapter = new BaseFragmentAdapter<>(this);
        adapter.addFragment(ProgramErrorFragment.newInstance(0));
        adapter.addFragment(ProgramErrorFragment.newInstance(1));
        pvFeedback.setAdapter(adapter);
        pvFeedback.setOffscreenPageLimit(adapter.getCount());
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
                nvFeedback.setSelectedItemId(R.id.feedback_program_error);
                break;
            case 1:
                nvFeedback.setSelectedItemId(R.id.feedback_product_suggestions);
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
            case R.id.feedback_program_error:
                pvFeedback.setCurrentItem(0);
                return true;
            case R.id.feedback_product_suggestions:
                pvFeedback.setCurrentItem(1);
                return true;
            default:
                break;
        }
        return false;
    }
}