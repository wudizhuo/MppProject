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
import com.mpp.project.business.Author;
import com.mpp.project.dataaccess.DataAccessFacade;

import java.util.ArrayList;
import java.util.Date;

public class AddBook extends BaseActivity implements View.OnClickListener {

    private EditText et_numberOfCopies;
    private EditText et_maximumCheckout;
    private EditText tx_title;
    private EditText tx_ISBN;
    private TextInputLayout ly_numberOfCopies;
    private TextInputLayout ly_maximumCheckout;
    private TextInputLayout ly_title;
    private TextInputLayout ly_ISBN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        findViewById(R.id.btn_done).setOnClickListener(this);
        ly_numberOfCopies = (TextInputLayout) findViewById(R.id.ly_numberOfCopies);
        et_numberOfCopies = (EditText) findViewById(R.id.tx_numberOfCopies);

        ly_maximumCheckout = (TextInputLayout) findViewById(R.id.ly_maximumCheckout);
        et_maximumCheckout = (EditText) findViewById(R.id.tx_maximumCheckout);

        ly_title = (TextInputLayout) findViewById(R.id.ly_title);
        tx_title = (EditText) findViewById(R.id.tx_title);

        ly_ISBN = (TextInputLayout) findViewById(R.id.ly_ISBN);
        tx_ISBN = (EditText) findViewById(R.id.tx_ISBN);


    }

    public static Intent getIntentToMe(Context context) {
        return new Intent(context, AddBook.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done:
                done();
                break;
            default:
                break;
        }
    }

    private void done() {
        ly_ISBN.setErrorEnabled(false);
        ly_title.setErrorEnabled(false);
        ly_numberOfCopies.setErrorEnabled(false);
        ly_maximumCheckout.setErrorEnabled(false);

        String ISBN = tx_ISBN.getText().toString();
        if (TextUtils.isEmpty(ISBN)) {
            ly_ISBN.setError("please input ISBN");
            return;
        }
        String title = tx_title.getText().toString();
        if (TextUtils.isEmpty(title)) {
            ly_title.setError("please input title");
            return;
        }
        String numberOfCopies = et_numberOfCopies.getText().toString();
        if (TextUtils.isEmpty(numberOfCopies)) {
            ly_numberOfCopies.setError("please input numberOfCopies");
            return;
        }
        String maximumCheckout = et_maximumCheckout.getText().toString();
        if (TextUtils.isEmpty(maximumCheckout)) {
            ly_maximumCheckout.setError("please input maximumCheckout");
            return;
        }

        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        ArrayList<Author> authors = new ArrayList<>();
        com.mpp.project.business.Book book = new com.mpp.project.business.Book(ISBN, title, Integer.valueOf(numberOfCopies), new Date(), authors);
        dataAccessFacade.saveBook(book);
        finish();
    }
}
