package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mpp.project.R;
import com.mpp.project.business.Author;
import com.mpp.project.dataaccess.DataAccessFacade;

import java.util.ArrayList;
import java.util.List;

public class AddBook extends BaseActivity implements View.OnClickListener {

    private EditText tx_ISBN;
    private EditText tx_title;
    private EditText et_maximumCheckout;
    private EditText et_numberOfCopies;
    private TextInputLayout ly_numberOfCopies;
    private TextInputLayout ly_maximumCheckout;
    private TextInputLayout ly_title;
    private TextInputLayout ly_ISBN;
    public final static int REQUESTCODE = 0;
    private TextView tv_authors;
    private List<Author> authors;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        findViewById(R.id.btn_addAuthor).setOnClickListener(this);
        findViewById(R.id.btn_done).setOnClickListener(this);
        ly_numberOfCopies = (TextInputLayout) findViewById(R.id.ly_numberOfCopies);
        et_numberOfCopies = (EditText) findViewById(R.id.tx_numberOfCopies);

        ly_maximumCheckout = (TextInputLayout) findViewById(R.id.ly_maximumCheckout);
        et_maximumCheckout = (EditText) findViewById(R.id.tx_maximumCheckout);

        ly_title = (TextInputLayout) findViewById(R.id.ly_title);
        tx_title = (EditText) findViewById(R.id.tx_title);

        ly_ISBN = (TextInputLayout) findViewById(R.id.ly_ISBN);
        tx_ISBN = (EditText) findViewById(R.id.tx_ISBN);

        tv_authors = (TextView) findViewById(R.id.tv_authors);
        authors = new ArrayList<>();
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
            case R.id.btn_addAuthor:
                addAuthor();
                break;
            default:
                break;
        }
    }

    private void addAuthor() {
        startActivityForResult(AddAuthor.getIntentToMe(AddBook.this), REQUESTCODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            Author author = (Author) data.getSerializableExtra("author");
            authors.add(author);
            tv_authors.setText(tv_authors.getText() + author.getFirstName() + " ");
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
        String maximumCheckout = et_maximumCheckout.getText().toString();
        if (TextUtils.isEmpty(maximumCheckout)) {
            ly_maximumCheckout.setError("please input maximumCheckout");
            return;
        }
        String numberOfCopies = et_numberOfCopies.getText().toString();
        if (TextUtils.isEmpty(numberOfCopies)) {
            ly_numberOfCopies.setError("please input numberOfCopies");
            return;
        }

        if (authors.isEmpty()) {
            Toast.makeText(this, "Please input Authors", Toast.LENGTH_SHORT).show();
            return;
        }

        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        com.mpp.project.business.Book book = new com.mpp.project.business.Book(ISBN, title, maximumCheckout, numberOfCopies, authors);
        dataAccessFacade.saveBook(book);
        finish();
    }
}
