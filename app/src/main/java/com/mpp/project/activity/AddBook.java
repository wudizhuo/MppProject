package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mpp.project.R;
import com.mpp.project.business.Book;
import com.mpp.project.dataaccess.DataAccessFacade;

public class AddBook extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        findViewById(R.id.btn_done).setOnClickListener(this);
    }

    public static Intent getIntentToMe(Context context) {
        return new Intent(context, AddBook.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done:
                DataAccessFacade dataAccessFacade = new DataAccessFacade();
                Book book = new Book(0, "", "");
                dataAccessFacade.saveBook(book);
                finish();
                break;
            default:
                break;
        }
    }
}
