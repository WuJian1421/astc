package com.example.astc.view.activity.home;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.util.AppUtil;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.hjq.toast.ToastUtils;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.QRCodeDecoder;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

/**
 * 扫一扫
 * 2019-12-25
 *
 * @author
 */
public class ScanItActivity extends BaseLazyActivity implements QRCodeView.Delegate {

    @BindView(R.id.zb_v_scan)
    ZXingView zbVScan;
    @BindView(R.id.iv_open_flash)
    AppCompatImageView ivOpenFlash;

    private boolean on = true;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan_it;
    }

    @Override
    public void onRightClick(View v) {
        super.onRightClick(v);
        PhotoActivity.start(this, new PhotoActivity.OnPhotoSelectListener() {

            @Override
            public void onSelect(List<String> data) {
                getSoundEffects();
                Bitmap bitmap = BitmapFactory.decodeFile(data.get(0));
                decode(bitmap, "解析二维码失败");
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAuthority();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (AppUtil.isObject(zbVScan)) {
            //关闭摄像头预览，并且隐藏扫描框
            zbVScan.stopCamera();
            //销毁二维码扫描控件
            zbVScan.onDestroy();
        }
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initData() {
        getAuthority();
        zbVScan.setDelegate(this);
    }

    /**
     * 处理扫描结果
     *
     * @param result 摄像头扫码时只要回调了该方法 result 就一定有值，不会为 null。解析本地图片或 Bitmap 时 result 可能为 null
     */
    @Override
    public void onScanQRCodeSuccess(String result) {
        getSoundEffects();
        ToastUtils.show(result);
        finish();
    }

    /**
     * 摄像头环境亮度发生变化
     *
     * @param isDark 是否变暗
     */
    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
        // 这里是通过修改提示文案来展示环境是否过暗的状态，接入方也可以根据 isDark 的值来实现其他交互效果
        String tipText = zbVScan.getScanBoxView().getTipText();
        String ambientBrightnessTip = "\n" + getString(R.string.flash_tips);
        if (isDark) {
            if (!tipText.contains(ambientBrightnessTip)) {
                zbVScan.getScanBoxView().setTipText(tipText + ambientBrightnessTip);
            }
        } else {
            if (tipText.contains(ambientBrightnessTip)) {
                tipText = tipText.substring(0, tipText.indexOf(ambientBrightnessTip));
                zbVScan.getScanBoxView().setTipText(tipText);
            }
        }
    }

    /**
     * 处理打开相机出错
     */
    @Override
    public void onScanQRCodeOpenCameraError() {
        ToastUtils.show(getString(R.string.photo_launch_fail));
    }

    private void initZingView() {
        // 打开后置摄像头开始预览，但是并未开始识别
        zbVScan.startCamera();
        // 显示扫描框，并开始识别
        zbVScan.startSpotAndShowRect();
        zbVScan.startSpot();
    }

    /**
     * 动态权限
     */
    private void getAuthority() {
        XXPermissions.with(this)
                .permission(Permission.CAMERA)
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        initZingView();
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if (quick) {
                            ToastUtils.show(R.string.common_permission_fail);
                            XXPermissions.gotoPermissionSettings(context, false);
                        } else {
                            ToastUtils.show(R.string.common_permission_hint);
                        }
                    }
                });
    }

    @SuppressLint("StaticFieldLeak")
    private void decode(final Bitmap bitmap, final String errorTip) {
        /*
        这里没有处理匿名 AsyncTask 内部类导致 Activity 泄漏的问题
        请开发在使用时自行处理匿名内部类导致Activity内存泄漏的问题，处理方式可参考 https://github
        .com/GeniusVJR/LearningNotes/blob/master/Part1/Android/Android%E5%86%85%E5%AD%98%E6%B3%84%E6%BC%8F%E6%80%BB%E7%BB%93.md
         */
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return QRCodeDecoder.syncDecodeQRCode(bitmap);
            }

            @Override
            protected void onPostExecute(String result) {
                Log.d("TAG", "----->" + "图片文字：" + errorTip);
            }
        }.execute();
    }

    /**
     * 音效
     */
    private void getSoundEffects() {
        try {
            AssetFileDescriptor descriptor = context.getAssets().openFd("di.mp3");
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(),
                    descriptor.getStartOffset(), descriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.iv_open_flash, R.id.zb_v_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_open_flash:
                if (on) {
                    on = false;
                    //打开闪光灯
                    zbVScan.openFlashlight();
                    ivOpenFlash.setBackgroundResource(R.mipmap.on_flash);
                } else {
                    on = true;
                    //关闭闪光灯
                    zbVScan.closeFlashlight();
                    ivOpenFlash.setBackgroundResource(R.mipmap.off_flash);
                }
                break;
            case R.id.zb_v_scan:
                getAuthority();
                break;
            default:
                break;
        }
    }
}
