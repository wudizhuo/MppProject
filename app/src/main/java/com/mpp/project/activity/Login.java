package com.mpp.project.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

import com.mpp.project.R;
import com.mpp.project.business.Person;
import com.mpp.project.dataaccess.DataAccessFacade;

public class Login extends BaseActivity {

    private EditText tx_username;
    private EditText tx_password;
    private DataAccessFacade dataAccessFacade;
    public TextInputLayout lyPassword;
    public TextInputLayout lyUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tx_username = (EditText) findViewById(R.id.tx_username);
        tx_password = (EditText) findViewById(R.id.tx_password);
        lyUserName = (TextInputLayout) findViewById(R.id.ly_username);
        lyPassword = (TextInputLayout) findViewById(R.id.ly_password);
        dataAccessFacade = new DataAccessFacade();
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        lyPassword.setErrorEnabled(false);
        String userName = tx_username.getText().toString();
        String password = tx_password.getText().toString();
        Person person = dataAccessFacade.readPerson(userName);
        if (person == null || !password.equals(person.getPassWord())) {
            lyPassword.setError(getResources().getString(R.string.msg_empty_user));
            return;
        }

    }
}
