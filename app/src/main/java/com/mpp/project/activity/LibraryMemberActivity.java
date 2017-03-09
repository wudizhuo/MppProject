package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.mpp.project.R;

public class LibraryMemberActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_memberId;
    private TextInputLayout lv_memberId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_member);
        findViewById(R.id.btn_addMember).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);
        et_memberId = (EditText) findViewById(R.id.et_memberId);
        lv_memberId = (TextInputLayout) findViewById(R.id.lv_memberId);
    }

    public static Intent getIntentToMe(Context context) {
        return new Intent(context, LibraryMemberActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_query:
                query();
                break;
            case R.id.btn_addMember:
                Intent i = new Intent(this, AddMember.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    private void query() {
        String memberId = et_memberId.getText().toString();
        if (TextUtils.isEmpty(memberId)) {
            lv_memberId.setError("please input value");
            return;
        }
        startActivity(CheckoutRecordActivity.getIntentToMe(LibraryMemberActivity.this, Integer.parseInt(memberId)));
    }
}
