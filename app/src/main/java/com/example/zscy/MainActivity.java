package com.example.zscy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.zscy.gvAdapterTime.GridViewAdapterTime;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnToEditReminder = findViewById(R.id.btn_to_reminder);
        Button mBtnToLogin = findViewById(R.id.btn_to_login);
        mBtnToLogin.setOnClickListener(this);
        mBtnToEditReminder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_to_login:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_to_reminder:
                intent = new Intent(this, EditReminderActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
