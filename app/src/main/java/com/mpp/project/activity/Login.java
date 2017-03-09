package com.mpp.project.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

import com.mpp.project.R;
import com.mpp.project.UserInfoMgr;
import com.mpp.project.business.Person;
import com.mpp.project.controller.MemberController;
import com.mpp.project.dataaccess.DataAccessFacade;

public class Login extends BaseActivity implements View.OnClickListener {

    private EditText tx_userId;
    private EditText tx_password;
    private DataAccessFacade dataAccessFacade;
    public TextInputLayout lyPassword;
    public TextInputLayout lyUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tx_userId = (EditText) findViewById(R.id.tx_userId);
        tx_password = (EditText) findViewById(R.id.tx_password);
        lyUserName = (TextInputLayout) findViewById(R.id.ly_username);
        lyPassword = (TextInputLayout) findViewById(R.id.ly_password);
        dataAccessFacade = new DataAccessFacade();
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    private void login() {
        lyPassword.setErrorEnabled(false);
        int userId = Integer.parseInt(tx_userId.getText().toString());
        String password = tx_password.getText().toString();

        MemberController memberController = new MemberController();
        Person person = memberController.readPerson(userId);
        if (person == null || !password.equals(person.getPassWord())) {
            lyPassword.setError(getResources().getString(R.string.msg_empty_user));
            return;
        }
        UserInfoMgr.getInstance().setUser(person);
        startActivity(Dashboard.getIntentToMe(this));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            default:
                break;
        }
    }
}
