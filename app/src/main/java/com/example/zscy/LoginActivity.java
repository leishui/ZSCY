package com.example.zscy;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    private EditText mEtAccount, mEtPassword;
    private ImageButton mIbtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEtAccount = findViewById(R.id.et_account);
        mEtPassword = findViewById(R.id.et_password);
        mIbtnBack = findViewById(R.id.ibtn_back);
        mIbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setEtIconSize(R.drawable.account,mEtAccount);
        setEtIconSize(R.drawable.password,mEtPassword);
    }

    private void setEtIconSize(int id, EditText v) {
        Drawable icon = getResources().getDrawable(id);
        icon.setBounds(0,0,50,65);
        v.setCompoundDrawables(icon,null,null,null);
    }

}
