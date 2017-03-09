package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mpp.project.R;
import com.mpp.project.UserInfoMgr;
import com.mpp.project.business.Person;

public class Dashboard extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        View members = findViewById(R.id.btn_members);
        View books = findViewById(R.id.btn_books);

        if (UserInfoMgr.getInstance().getUser().getAuthorizationLevel().equals(Person.AuthorizationLevel.LIBRARIAN)) {
            members.setVisibility(View.GONE);
        }

        books.setOnClickListener(this);
        findViewById(R.id.btn_logout).setOnClickListener(this);
        members.setOnClickListener(this);
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
