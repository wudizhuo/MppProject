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

public class Book extends BaseActivity implements View.OnClickListener {

    private EditText et_isbn;
    private TextInputLayout lv_isbn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        findViewById(R.id.btn_addBook).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);
        et_isbn = (EditText) findViewById(R.id.et_isbn);
        lv_isbn = (TextInputLayout) findViewById(R.id.lv_isbn);
    }

    public static Intent getIntentToMe(Context context) {
        return new Intent(context, Book.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_query:
                query();
                break;
            case R.id.btn_addBook:
                startActivity(AddBook.getIntentToMe(Book.this));
                break;
            default:
                break;
        }
    }

    private void query() {
        String isbnString = et_isbn.getText().toString();
        if (TextUtils.isEmpty(isbnString)) {
            lv_isbn.setError("please input value");
            return;
        }
        int isbn = Integer.parseInt(isbnString);
        startActivity(BookDetail.getIntentToMe(Book.this, isbn));
    }
}
