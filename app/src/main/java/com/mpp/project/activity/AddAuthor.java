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
import com.mpp.project.business.Address;
import com.mpp.project.business.Author;

public class AddAuthor extends BaseActivity implements View.OnClickListener {

    private EditText tx_phonenumber;
    private EditText tv_lastName;
    private EditText tv_city;
    private EditText tv_firstName;
    private TextInputLayout ly_firstName;
    private TextInputLayout ly_city;
    private TextInputLayout ly_lastName;
    private TextInputLayout ly_phonenumber;
    private TextInputLayout ly_credentials;
    private EditText tx_credentials;
    private TextInputLayout ly_bio;
    private EditText tx_bio;
    private TextInputLayout ly_street;
    private EditText tv_street;
    private TextInputLayout ly_state;
    private EditText tv_state;
    private TextInputLayout ly_zip;
    private EditText tv_zip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addauthor);

        ly_firstName = (TextInputLayout) findViewById(R.id.ly_firstName);
        tv_firstName = (EditText) findViewById(R.id.tv_firstName);

        ly_lastName = (TextInputLayout) findViewById(R.id.ly_lastName);
        tv_lastName = (EditText) findViewById(R.id.tv_lastName);

        ly_phonenumber = (TextInputLayout) findViewById(R.id.ly_phonenumber);
        tx_phonenumber = (EditText) findViewById(R.id.tx_phonenumber);

        ly_credentials = (TextInputLayout) findViewById(R.id.ly_credentials);
        tx_credentials = (EditText) findViewById(R.id.tx_credentials);

        ly_bio = (TextInputLayout) findViewById(R.id.ly_bio);
        tx_bio = (EditText) findViewById(R.id.tx_bio);

        ly_street = (TextInputLayout) findViewById(R.id.ly_street);
        tv_street = (EditText) findViewById(R.id.tv_street);
        ly_city = (TextInputLayout) findViewById(R.id.ly_city);
        tv_city = (EditText) findViewById(R.id.tv_city);
        ly_state = (TextInputLayout) findViewById(R.id.ly_state);
        tv_state = (EditText) findViewById(R.id.tv_state);
        ly_zip = (TextInputLayout) findViewById(R.id.ly_zip);
        tv_zip = (EditText) findViewById(R.id.tv_zip);

        findViewById(R.id.btn_done).setOnClickListener(this);
    }

    public static Intent getIntentToMe(Context context) {
        return new Intent(context, AddAuthor.class);
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
        ly_phonenumber.setErrorEnabled(false);
        ly_lastName.setErrorEnabled(false);
        ly_firstName.setErrorEnabled(false);
        ly_city.setErrorEnabled(false);


        String firstName = tv_firstName.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            ly_firstName.setError("please input firstName");
            return;
        }
        String lastName = tv_lastName.getText().toString();
        if (TextUtils.isEmpty(lastName)) {
            ly_lastName.setError("please input lastName");
            return;
        }
        String phonenumber = tx_phonenumber.getText().toString();
        if (TextUtils.isEmpty(phonenumber)) {
            ly_phonenumber.setError("please input phonenumber");
            return;
        }

        String credentials = tx_credentials.getText().toString();
        if (TextUtils.isEmpty(credentials)) {
            ly_credentials.setError("please input credentials");
            return;
        }

        String bio = tx_bio.getText().toString();
        if (TextUtils.isEmpty(bio)) {
            ly_bio.setError("please input bio");
            return;
        }

        String street = tv_street.getText().toString();
        if (TextUtils.isEmpty(street)) {
            ly_street.setError("please input street");
            return;
        }

        String city = tv_city.getText().toString();
        if (TextUtils.isEmpty(city)) {
            ly_city.setError("please input city");
            return;
        }
        String state = tv_state.getText().toString();
        if (TextUtils.isEmpty(state)) {
            ly_state.setError("please input state");
            return;
        }
        String zip = tv_zip.getText().toString();
        if (TextUtils.isEmpty(zip)) {
            ly_zip.setError("please input zip");
            return;
        }

        Intent data = new Intent();
        Address address1 = new Address(street, city, state, zip, "US");
        Author author = new Author(firstName, lastName, phonenumber, address1, credentials, bio);
        data.putExtra("author", author);
        setResult(RESULT_OK, data);
        finish();
    }

}
