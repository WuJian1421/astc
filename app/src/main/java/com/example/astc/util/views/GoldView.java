package com.example.astc.util.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.astc.R;
import com.example.astc.bean.GoldBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 金币漂浮动画
 * 2020-02-03
 *
 * @author
 */
public class GoldView extends FrameLayout {
    private static final int WHAT_ADD_PROGRESS = 1;
    /**
     * view变化的y抖动范围
     */
    private static final int CHANGE_RANGE = 10;
    /**
     * 控制抖动动画执行的快慢，人眼不能识别16ms以下的
     */
    public static final int PROGRESS_DELAY_MILLIS = 12;
    /**
     * 控制移除view的动画执行时间
     */
    public static final int REMOVE_DELAY_MILLIS = 2000;
    /**
     * 添加水滴时动画显示view执行的时间
     */
    public static final int ANIMATION_SHOW_VIEW_DURATION = 500;
    /**
     * 控制水滴动画的快慢
     */
    private List<Float> mSpds = Arrays.asList(0.5f, 0.3f, 0.2f, 0.1f);
    /**
     * x最多可选取的随机数值
     */
    private static final List<Float> X_MAX_CHOSE_RANDOMS = Arrays.asList(
            0.01f, 0.05f, 0.1f, 0.6f, 0.11f, 0.16f, 0.21f, 0.26f, 0.31f, 0.7f, 0.75f, 0.8f, 0.85f, 0.87f);
    /**
     * y最多可选取的随机数值
     */
    private static final List<Float> Y_MAX_CHOSE_RANDOMS = Arrays.asList(
            0.01f, 0.06f, 0.11f, 0.17f, 0.23f, 0.29f, 0.35f, 0.41f, 0.47f, 0.53f, 0.59f, 0.65f, 0.71f, 0.77f, 0.83f);
    /**
     * x坐标当前可选的随机数组
     */
    private List<Float> mXCurrentCanShoseRandoms = new ArrayList<>();
    /**
     * y坐标当前可选的随机数组
     */
    private List<Float> mYCurrentCanShoseRandoms = new ArrayList<>();
    /**
     * 已经选取x的随机数值
     */
    private List<Float> mXRandoms = new ArrayList<>();
    /**
     * 已经选取y的随机数值
     */
    private List<Float> mYRandoms = new ArrayList<>();
    private Random mRandom = new Random();
    private List<View> mViews = new ArrayList<>();
    private LayoutInflater mInflater;
    /**
     * 总的已经点击的金币
     */
    private int mTotalConsumeWater;
    /**
     * 是否开启动画
     */
    private boolean isOpenAnimtion;
    /**
     * 是否销毁动画
     */
    private boolean isCancelAnimtion;
    /**
     * 子view的x坐标和y坐标的最大取值
     */
    private int maxX, maxY;
    /**
     * 父控件对角线的距离
     */
    private float mMaxSpace;
    /**
     * view销毁时的点
     */
    private Point mDestroyPoint;

    public GoldView(@NonNull Context context) {
        this(context, null);
    }

    public GoldView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GoldView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(getContext());
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //根据isCancelAnim来标识是否退出，防止界面销毁时，再一次改变UI
            if (isCancelAnimtion) {
                return;
            }
            setOffSet();
            mHandler.sendEmptyMessageDelayed(WHAT_ADD_PROGRESS, PROGRESS_DELAY_MILLIS);
        }
    };

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMaxSpace = (float) Math.sqrt(w * w + h * h);
        mDestroyPoint = new Point((int) getX(), h);
        maxX = w;
        maxY = h;
    }

    /**
     * 界面销毁时回调
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    /**
     * 重置子view
     */
    private void reset() {
        isCancelAnimtion = true;
        isOpenAnimtion = false;
        for (int i = 0; i < mViews.size(); i++) {
            removeView(mViews.get(i));
        }
        mViews.clear();
        mXRandoms.clear();
        mYRandoms.clear();
        mYCurrentCanShoseRandoms.clear();
        mXCurrentCanShoseRandoms.clear();
        mHandler.removeCallbacksAndMessages(null);
    }

    /**
     * 设置水滴
     *
     * @param waters
     */
    public void setWaters(final List<GoldBean> waters) {
        if (waters == null || waters.isEmpty()) {
            return;
        }
        //确保初始化完成
        post(() -> setData(waters));
    }

    /**
     * 设置数据
     *
     * @param waters
     */
    private void setData(List<GoldBean> waters) {
        reset();
        isCancelAnimtion = false;
        setCurrentCanChoseRandoms();
        addWaterView(waters);
        setViewsSpd();
        startAnimation();
    }

    private void setCurrentCanChoseRandoms() {
        mXCurrentCanShoseRandoms.addAll(X_MAX_CHOSE_RANDOMS);
        mYCurrentCanShoseRandoms.addAll(Y_MAX_CHOSE_RANDOMS);
    }

    /**
     * 添加水滴view
     */
    private void addWaterView(List<GoldBean> waters) {
        for (int i = 0; i < waters.size(); i++) {
            final GoldBean water = waters.get(i);
            //子view的资源文件
            View view = mInflater.inflate(R.layout.item_gold, this, false);
            AppCompatTextView tvWater = view.findViewById(R.id.tv_water);
            tvWater.setText(String.valueOf(water.getNumber()));
            view.setTag(water);
            view.setOnClickListener(this::handViewClick);
            //随机设置view动画的方向
            view.setTag(R.string.isUp, mRandom.nextBoolean());
            setChildViewLocation(view);
            mViews.add(view);
            addShowViewAnimation(view);
        }
    }

    /**
     * 添加显示动画
     *
     * @param view
     */
    private void addShowViewAnimation(View view) {
        addView(view);
        view.setAlpha(0);
        view.setScaleX(0);
        view.setScaleY(0);
        view.animate().alpha(1).scaleX(1).scaleY(1).setDuration(ANIMATION_SHOW_VIEW_DURATION).start();
    }

    /**
     * 处理view点击
     *
     * @param view
     */
    private void handViewClick(View view) {
        //移除当前集合中的该view
        mViews.remove(view);
        Object tag = view.getTag();
        if (tag instanceof GoldBean) {
            GoldBean waterTag = (GoldBean) tag;
            mTotalConsumeWater += waterTag.getNumber();
            Log.d("TAG", "----->" + "gold:" + "当前点击的是：" + waterTag.getName() + "金币的值是:"
                    + waterTag.getNumber() + "总的金币数是" + mTotalConsumeWater);
        }
        view.setTag(R.string.original_y, view.getY());
        animRemoveView(view);
    }

    /**
     * 设置view在父控件中的位置
     *
     * @param view
     */
    private void setChildViewLocation(View view) {
        view.setX((float) (maxX * getXYRandom(mXCurrentCanShoseRandoms, mXRandoms)));
        view.setY((float) (maxY * getXYRandom(mYCurrentCanShoseRandoms, mYRandoms)));
        view.setTag(R.string.original_y, view.getY());
    }

    /**
     * 获取x轴或是y轴上的随机值
     *
     * @return
     */
    private double getXYRandom(List<Float> choseRandoms, List<Float> saveRandoms) {

        if (choseRandoms.size() <= 0) {
            //防止水滴别可选项的个数还要多，这里就重新对可选项赋值
            setCurrentCanChoseRandoms();
        }
        //取用一个随机数，就移除一个随机数，达到不用循环遍历来确保获取不一样的值
        float random = choseRandoms.get(mRandom.nextInt(choseRandoms.size()));
        choseRandoms.remove(random);
        saveRandoms.add(random);
        return random;
    }

    /**
     * 设置所有子view的加速度
     */
    private void setViewsSpd() {
        for (int i = 0; i < mViews.size(); i++) {
            View view = mViews.get(i);
            setSpd(view);
        }
    }

    /**
     * 设置View的spd
     *
     * @param view
     */
    private void setSpd(View view) {
        float spd = mSpds.get(mRandom.nextInt(mSpds.size()));
        view.setTag(R.string.spd, spd);
    }

    /**
     * 设置偏移
     */
    private void setOffSet() {
        for (int i = 0; i < mViews.size(); i++) {
            View view = mViews.get(i);
            //拿到上次view保存的速度
            float spd = (float) view.getTag(R.string.spd);
            //水滴初始的位置
            float original = (float) view.getTag(R.string.original_y);
            boolean isUp = (boolean) view.getTag(R.string.isUp);
            float translationY;
            //根据水滴tag中的上下移动标识移动view
            if (isUp) {
                translationY = view.getY() - spd;
            } else {
                translationY = view.getY() + spd;
            }
            //对水滴位移范围的控制
            if (translationY - original > CHANGE_RANGE) {
                translationY = original + CHANGE_RANGE;
                view.setTag(R.string.isUp, true);
            } else if (translationY - original < -CHANGE_RANGE) {
                translationY = original - CHANGE_RANGE;
                setSpd(view);
                view.setTag(R.string.isUp, false);
            }
            view.setY(translationY);
        }
    }

    /**
     * 获取两个点之间的距离
     *
     * @param p1
     * @param p2
     * @return
     */
    public float getDistance(Point p1, Point p2) {
        float x = Math.abs(p2.x - p1.x);
        float y = Math.abs(p2.y - p1.y);
        return (float) Math.sqrt(x * x + y * y);
    }

    /**
     * 动画移除view
     *
     * @param view
     */
    private void animRemoveView(final View view) {
        final float x = view.getX();
        final float y = view.getY();
        //计算直线距离
        float space = getDistance(new Point((int) x, (int) y), mDestroyPoint);

        ValueAnimator animator = ValueAnimator.ofFloat(x, 0);
        //根据距离计算动画执行时间
        animator.setDuration((long) (REMOVE_DELAY_MILLIS / mMaxSpace * space));
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (isCancelAnimtion) {
                    return;
                }
                float value = (float) valueAnimator.getAnimatedValue();
                float alpha = value / x;
                float translationY = y + (x - value) * (maxY - y) / x;
                setViewProperty(view, alpha, translationY, value);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //结束时从容器移除水滴
                removeView(view);
            }
        });
        animator.start();
    }

    /**
     * 设置view的属性
     *
     * @param view
     * @param alpha
     * @param translationY
     * @param translationX
     */
    private void setViewProperty(View view, float alpha, float translationY, float translationX) {
        view.setTranslationY(translationY);
        view.setTranslationX(translationX);
        view.setAlpha(alpha);
        view.setScaleY(alpha);
        view.setScaleX(alpha);
    }

    /**
     * 开启金币抖动动画
     */
    private void startAnimation() {
        if (isOpenAnimtion) {
            return;
        }
        mHandler.sendEmptyMessage(WHAT_ADD_PROGRESS);
        isOpenAnimtion = true;
    }

    /**
     * 销毁
     */
    private void onDestroy() {
        isCancelAnimtion = true;
        mHandler.removeCallbacksAndMessages(this);
    }
}
