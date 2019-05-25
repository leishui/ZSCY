package com.example.zscy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.zscy.gvAdapterTime.GridViewAdapterTime;

public class EditReminderActivity extends AppCompatActivity {

    private ImageButton mIbtnBack;
    private LinearLayout mLlTime;
    private PopupWindow mPwTime;
    private GridView mgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_reminder);
        mIbtnBack = findViewById(R.id.ibtn_back);
        mLlTime = findViewById(R.id.ll_time);

        mLlTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftInput(EditReminderActivity.this, mLlTime);
                @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.grid_view_time, null);
                ImageButton imageButtonBack = view.findViewById(R.id.ibtn_back);
                imageButtonBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPwTime.dismiss();
                    }
                });
                mgv = view.findViewById(R.id.gv_time);
                mgv.setAdapter(new GridViewAdapterTime(EditReminderActivity.this));
                mPwTime = new PopupWindow(view, mLlTime.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPwTime.setAnimationStyle(R.style.PopupWindowAnimation);
                mPwTime.setOutsideTouchable(false);
                mPwTime.setFocusable(true);
                mPwTime.showAtLocation(mLlTime, Gravity.BOTTOM, 0, 0);
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.5f;
                getWindow().setAttributes(lp);
                mPwTime.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
            }
        });
        mIbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //隐藏键盘
    public static void hideSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
