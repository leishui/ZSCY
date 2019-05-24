package com.example.zscy;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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
                @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.grid_view_time,null);
                mgv = view.findViewById(R.id.gv_time);
                mgv.setAdapter(new GridViewAdapterTime(EditReminderActivity.this));
                mPwTime = new PopupWindow(view,mLlTime.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPwTime.setOutsideTouchable(false);
                mPwTime.setFocusable(true);
                mPwTime.showAtLocation(mLlTime, Gravity.BOTTOM, 0, 0);
            }
        });
        mIbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
