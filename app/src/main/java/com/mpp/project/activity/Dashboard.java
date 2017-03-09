package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.mpp.project.R;

public class Dashboard extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        findViewById(R.id.btn_books).setOnClickListener(this);
        findViewById(R.id.btn_logout).setOnClickListener(this);
        findViewById(R.id.btn_members).setOnClickListener(this);
    }

    public static Intent getIntentToMe(Context context) {
        Intent intent = new Intent(context, Dashboard.class);
        return intent;
    }

    private void loginOut() {
        Intent intent = new Intent();
        intent.setClass(this, Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_books:
                startActivity(Book.getIntentToMe(Dashboard.this));
                break;
            case R.id.btn_logout:
                loginOut();
                break;
            case R.id.btn_members:
                Intent i = new Intent(this, Memebers.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
