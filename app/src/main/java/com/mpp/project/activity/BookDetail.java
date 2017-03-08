package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mpp.project.R;
import com.mpp.project.business.*;
import com.mpp.project.business.Book;
import com.mpp.project.dataaccess.DataAccessFacade;

public class BookDetail extends BaseActivity implements View.OnClickListener {

    private TextView tv_numberOfCopies;
    private Book book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int isbn = getIntent().getIntExtra("isbn", -1);
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        book = dataAccessFacade.queryBook(isbn);
        if (book == null) {
            Toast.makeText(this, "Don't have this book", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setContentView(R.layout.activity_bookdetail);

        ((TextView) findViewById(R.id.tv_isbn)).setText("ISBN:" + book.getIsbn());
        ((TextView) findViewById(R.id.tx_title)).setText("Title:" + book.getTitle());
        ((TextView) findViewById(R.id.tv_availability)).setText("Availability:" + book.isAvailability());
        ((TextView) findViewById(R.id.tv_maximumCheckout)).setText("MaximumCheckout:" + book.getMaximumCheckout());
        tv_numberOfCopies = (TextView) findViewById(R.id.tv_numberOfCopies);
        tv_numberOfCopies.setText("NumberOfCopies:" + book.getNumberOfCopies());

        findViewById(R.id.btn_addCopy).setOnClickListener(this);
        findViewById(R.id.btn_checkout).setOnClickListener(this);
    }

    public static Intent getIntentToMe(Context context, int isbn) {
        Intent intent = new Intent(context, BookDetail.class);
        intent.putExtra("isbn", isbn);
        return intent;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addCopy:
                addCopy();
                break;
            case R.id.btn_checkout:
                checkout();
                break;
            default:
                break;
        }
    }

    private void checkout() {

    }

    private void addCopy() {
        int numberOfCopies = Integer.valueOf(book.getNumberOfCopies());
        numberOfCopies++;
        book.setNumberOfCopies("" + numberOfCopies);
        new DataAccessFacade().saveBook(book);
        tv_numberOfCopies.setText("NumberOfCopies:" + book.getNumberOfCopies());
        Toast.makeText(BookDetail.this, "Add Copy Success", Toast.LENGTH_SHORT).show();
    }
}
