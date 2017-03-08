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
import com.mpp.project.dataaccess.DataAccessFacade;

public class BookDetail extends BaseActivity {

    private Button btn_addCopy;
    private TextView tv_numberOfCopies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int isbn = getIntent().getIntExtra("isbn", -1);
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        final com.mpp.project.business.Book book = dataAccessFacade.queryBook(isbn);
        if (book == null) {
            Toast.makeText(this, "Don't have this book", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setContentView(R.layout.activity_bookdetail);
        btn_addCopy = (Button) findViewById(R.id.btn_addCopy);

        ((TextView) findViewById(R.id.tv_isbn)).setText("ISBN:" + book.getIsbn());
        ((TextView) findViewById(R.id.tx_title)).setText("Title:" + book.getTitle());
        ((TextView) findViewById(R.id.tv_availability)).setText("Availability:" + book.isAvailability());
        ((TextView) findViewById(R.id.tv_maximumCheckout)).setText("MaximumCheckout:" + book.getMaximumCheckout());
        tv_numberOfCopies = (TextView) findViewById(R.id.tv_numberOfCopies);
        tv_numberOfCopies.setText("NumberOfCopies:" + book.getNumberOfCopies());

        btn_addCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfCopies = Integer.valueOf(book.getNumberOfCopies());
                numberOfCopies++;
                book.setNumberOfCopies("" + numberOfCopies);
                new DataAccessFacade().saveBook(book);
                tv_numberOfCopies.setText("NumberOfCopies:" + book.getNumberOfCopies());
                Toast.makeText(BookDetail.this, "Add Copy Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Intent getIntentToMe(Context context, int isbn) {
        Intent intent = new Intent(context, BookDetail.class);
        intent.putExtra("isbn", isbn);
        return intent;
    }
}
