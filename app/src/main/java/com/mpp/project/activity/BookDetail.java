package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.mpp.project.dataaccess.DataAccessFacade;

public class BookDetail extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int isbn = getIntent().getIntExtra("isbn", -1);
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        com.mpp.project.business.Book book = dataAccessFacade.queryBook(isbn);
        if (book == null) {
            Toast.makeText(this, "Don't have this book", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

    }

    public static Intent getIntentToMe(Context context, int isbn) {
        Intent intent = new Intent(context, BookDetail.class);
        intent.putExtra("isbn", isbn);
        return intent;
    }
}
