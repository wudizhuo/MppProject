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
import com.mpp.project.UserInfoMgr;
import com.mpp.project.business.Book;
import com.mpp.project.business.LibraryMember;
import com.mpp.project.business.Person;
import com.mpp.project.controller.BookController;
import com.mpp.project.controller.MemberController;
import com.mpp.project.dataaccess.DataAccessFacade;

public class BookDetail extends BaseActivity implements View.OnClickListener {

    private TextView tv_numberOfCopies;
    private Book book;
    private TextInputLayout lv_memberId;
    private EditText et_memberId;
    private TextView tv_memberInfo;
    private LibraryMember member;
    private TextView tv_availability;
    private BookController bookController;
    private MemberController memberController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int isbn = getIntent().getIntExtra("isbn", -1);
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        book = dataAccessFacade.queryBook(isbn + "");
        if (book == null) {
            Toast.makeText(this, "Don't have this book", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setContentView(R.layout.activity_bookdetail);
        bookController = new BookController();
        memberController = new MemberController();
        ((TextView) findViewById(R.id.tv_isbn)).setText("ISBN:" + book.getIsbn());
        ((TextView) findViewById(R.id.tx_title)).setText("Title:" + book.getTitle());
        tv_availability = (TextView) findViewById(R.id.tv_availability);
        tv_availability.setText("Availability:" + book.isAvailability());
        ((TextView) findViewById(R.id.tv_maximumCheckout)).setText("MaximumCheckout:" + book.getMaximumCheckout());
        tv_numberOfCopies = (TextView) findViewById(R.id.tv_numberOfCopies);
        tv_numberOfCopies.setText("NumberOfCopies:" + book.getNumberOfCopies());

        et_memberId = (EditText) findViewById(R.id.et_memberId);
        lv_memberId = (TextInputLayout) findViewById(R.id.lv_memberId);
        tv_memberInfo = (TextView) findViewById(R.id.tv_memberInfo);

        findViewById(R.id.btn_addCopy).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);
        findViewById(R.id.btn_checkout).setOnClickListener(this);

        if (UserInfoMgr.getInstance().getUser().getAuthorizationLevel().equals(Person.AuthorizationLevel.ADMIN)) {
            findViewById(R.id.cv_checkout).setVisibility(View.GONE);
        }

        if (UserInfoMgr.getInstance().getUser().getAuthorizationLevel().equals(Person.AuthorizationLevel.LIBRARIAN)) {
            findViewById(R.id.btn_addCopy).setVisibility(View.GONE);
        }
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
            case R.id.btn_query:
                query();
                break;
            default:
                break;
        }
    }

    private void showRecord(int memberId) {
        startActivity(CheckoutRecordActivity.getIntentToMe(BookDetail.this, memberId));
    }

    private void query() {
        String memberIdStr = et_memberId.getText().toString();
        if (TextUtils.isEmpty(memberIdStr)) {
            lv_memberId.setError("please input value");
            return;
        }
        int memberId = Integer.parseInt(memberIdStr);
        member = (LibraryMember) memberController.readPerson(memberId);

        if (member == null) {
            lv_memberId.setError("member not found");
            return;
        }
        tv_memberInfo.setText(member.toString());
    }

    private void checkout() {
        if (member == null) {
            lv_memberId.setError("member not found");
            return;
        }
        if (!book.isAvailability()) {
            Toast.makeText(this, "book is not available", Toast.LENGTH_SHORT).show();
        }

        bookController.checkout(this.book, member);

        tv_availability.setText("Availability:" + book.isAvailability());

        Toast.makeText(this, "Check out success", Toast.LENGTH_SHORT).show();
        showRecord(member.getUserId());
        finish();
    }

    private void addCopy() {
        bookController.addCopy(book);
        tv_numberOfCopies.setText("NumberOfCopies:" + book.getNumberOfCopies());
        Toast.makeText(BookDetail.this, "Add Copy Success", Toast.LENGTH_SHORT).show();
    }

}
