package com.example.astc.view.activity.conversation;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.WindowManager;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.astc.R;
import com.example.astc.base.BaseLazyActivity;
import com.example.astc.bean.DialogueBean;
import com.example.astc.view.adapter.DialogueAdapter;
import com.hjq.bar.TitleBar;
import com.hjq.toast.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.FOCUS_DOWN;

/**
 * 会话-聊天页面
 * 2020-01-11
 *
 * @author
 */
public class DialogueActivity extends BaseLazyActivity {

    @BindView(R.id.sv_dialogue)
    NestedScrollView svDialogue;
    private List<DialogueBean> dialogueBeans;
    private DialogueAdapter dialogueAdapter;

    @BindView(R.id.rv_dialogue)
    RecyclerView rvDialogue;
    @BindView(R.id.titleBar)
    TitleBar titleBar;
    @BindView(R.id.bu_send)
    AppCompatButton buSend;
    @BindView(R.id.et_msg)
    AppCompatEditText etMsg;

    /**
     * 获取布局 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_dialogue;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //Rv
        LinearLayoutManager layoutManager = new LinearLayoutManager
                (context, LinearLayoutManager.VERTICAL, false);
        layoutManager.setStackFromEnd(true);
        rvDialogue.setLayoutManager(layoutManager);
        dialogueBeans = new ArrayList<>();
        //假数据
        dialogueBeans.add(new DialogueBean(2, "在吗？"));
        dialogueBeans.add(new DialogueBean(1, "在"));

        dialogueAdapter = new DialogueAdapter(R.layout.item_rv_dialogue, dialogueBeans);
        rvDialogue.setAdapter(dialogueAdapter);

        Handler handler = new Handler();
        svDialogue.addOnLayoutChangeListener((v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
            handler.post(() -> {
                svDialogue.fullScroll(FOCUS_DOWN);
                etMsg.setFocusable(true);
                etMsg.setFocusableInTouchMode(true);
                etMsg.requestFocus();
                etMsg.findFocus();
            });
        });
    }

    @OnClick(R.id.bu_send)
    public void onViewClicked() {
        String message = etMsg.getText().toString().trim();
        if (TextUtils.isEmpty(message)) {
            ToastUtils.show("输入不能为空");
        } else {
            dialogueBeans.add(new DialogueBean(1, message));
            dialogueAdapter.notifyDataSetChanged();
            etMsg.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
