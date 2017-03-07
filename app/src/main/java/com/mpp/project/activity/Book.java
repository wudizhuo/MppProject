package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mpp.project.R;

public class Book extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        findViewById(R.id.btn_addBook).setOnClickListener(this);
    }

    public static Intent getIntentToMe(Context context) {
        return new Intent(context, Book.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addBook:
                startActivity(AddBook.getIntentToMe(Book.this));
                break;
            default:
                break;
        }
    }
}
