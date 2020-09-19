package com.example.astc;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.astc.base.Applications;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.base.BaseLazyFragment;
import com.example.astc.helper.ActivityStackManager;
import com.example.astc.util.views.BaseViewPagerView;
import com.example.astc.view.activity.mine.TransactionPasswordActivity;
import com.example.astc.view.adapter.BaseFragmentAdapter;
import com.example.astc.view.dialog.BaseDialog;
import com.example.astc.view.dialog.MessageDialog;
import com.example.astc.view.fragment.main.ApplicationFragment;
import com.example.astc.view.fragment.main.ConversationFragment;
import com.example.astc.view.fragment.main.HomeFragment;
import com.example.astc.view.fragment.main.MineFragment;
import com.example.astc.view.fragment.main.WealthFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;

/**
 * 首页
 * 2019-12-11
 *
 * @author
 */
public class MainActivity extends BaseLazyActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener {

    @BindView(R.id.bv_pv_main)
    BaseViewPagerView bvPvMain;
    @BindView(R.id.bn_main)
    BottomNavigationView bnMain;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        Applications applications = (Applications) getApplication();
        if (applications.getNewLoginBean() != null) {
            Log.d("TAG", "----->" + "trade:" + applications.getNewLoginBean().getTradePasswordState());
            // 0：没有交易密码 1：设置过交易密码
            if (applications.getNewLoginBean().getTradePasswordState() == 0) {
                new MessageDialog.Builder(this)
                        // 标题可以不用填写
                        .setTitle(R.string.set_transaction_password)
                        // 内容必须要填写
                        .setMessage(R.string.transaction_password_tips)
                        .setListener(new MessageDialog.OnListener() {

                            @Override
                            public void onConfirm(BaseDialog dialog) {
                                dialog.dismiss();
                                //设置交易密码
                                Intent intent = new Intent(context, TransactionPasswordActivity.class);
                                intent.putExtra("type", 0);
                                startActivity(intent);
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        }
        //Tab
        bvPvMain.addOnPageChangeListener(this);
        bnMain.setOnNavigationItemSelectedListener(this);
        //ViewPager 适配器
        BaseFragmentAdapter<BaseLazyFragment> adapter = new BaseFragmentAdapter<>(this);
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new WealthFragment());
        adapter.addFragment(new ConversationFragment());
        adapter.addFragment(new ApplicationFragment());
        adapter.addFragment(new MineFragment());
        bvPvMain.setAdapter(adapter);
        bvPvMain.setOffscreenPageLimit(adapter.getCount());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        exitApp();
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 关闭应用程序
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void exitApp() {
        // 移动到上一个任务栈，避免侧滑引起的不良反应
        moveTaskToBack(false);
        postDelayed(() -> {
            // 进行内存优化，销毁掉所有的界面
            ActivityStackManager.getInstance().finishAllActivities();
        }, 300);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.main_home:
                bvPvMain.setCurrentItem(0);
                return true;
            case R.id.main_wealth:
                bvPvMain.setCurrentItem(1);
                return true;
            case R.id.main_conversation:
                bvPvMain.setCurrentItem(2);
                return true;
            case R.id.main_application:
                bvPvMain.setCurrentItem(3);
                return true;
            case R.id.main_mine:
                bvPvMain.setCurrentItem(4);
                return true;
            default:
                break;
        }
        return false;
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
                bnMain.setSelectedItemId(R.id.main_home);
                break;
            case 1:
                bnMain.setSelectedItemId(R.id.main_wealth);
                break;
            case 2:
                bnMain.setSelectedItemId(R.id.main_conversation);
                break;
            case 3:
                bnMain.setSelectedItemId(R.id.main_application);
                break;
            case 4:
                bnMain.setSelectedItemId(R.id.main_mine);
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
}