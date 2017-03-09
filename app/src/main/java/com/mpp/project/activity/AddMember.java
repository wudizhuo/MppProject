package com.mpp.project.activity;

import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mpp.project.R;
import com.mpp.project.UserInfoMgr;
import com.mpp.project.controller.MemberController;

import java.util.HashMap;

public class AddMember extends BaseActivity implements View.OnClickListener {

    private static final int MIN_LENGTH = 3;
    private TextView tv_lmStatus;
    private EditText tv_lmMemberId; // TODO: Validation and number char mix and length??
    private EditText tv_lmFirstName;
    private EditText tv_lmLastName;
    private EditText tv_lmCity;
    private EditText tv_lmStreet;
    private EditText tv_lmState;
    private EditText tv_lmZip;
    private EditText tv_lmCountry;
    private EditText tv_lmPhoneNumber;

    private TextInputLayout ly_lmMemberId;
    private TextInputLayout ly_lmfirstName;
    private TextInputLayout ly_lmlastName;
    private TextInputLayout ly_lmstreet;
    private TextInputLayout ly_lmcity;
    private TextInputLayout ly_lmstate;
    private TextInputLayout ly_lmzip;
    private TextInputLayout ly_lmcounty;
    private TextInputLayout ly_lmphonenumber;

    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        tv_lmStatus = (TextView) findViewById(R.id.tv_lmStatus);

        tv_lmMemberId = (EditText) findViewById(R.id.tx_lmMemberId);
        tv_lmFirstName = (EditText) findViewById(R.id.tx_lmFirstName);
        tv_lmLastName = (EditText) findViewById(R.id.tx_lmLastName);
        tv_lmStreet = (EditText) findViewById(R.id.tx_lmStreet);
        tv_lmState = (EditText) findViewById(R.id.tx_lmState);
        tv_lmZip = (EditText) findViewById(R.id.tx_lmZip);
        tv_lmCountry = (EditText) findViewById(R.id.tx_lmCountry);
        tv_lmPhoneNumber = (EditText) findViewById(R.id.tx_lmPhoneNumber);
        tv_lmCity = (EditText) findViewById(R.id.tx_lmCity);

        ly_lmMemberId = (TextInputLayout) findViewById(R.id.ly_lmMemberId);
        ly_lmfirstName = (TextInputLayout) findViewById(R.id.ly_lmFirstName);
        ly_lmlastName = (TextInputLayout) findViewById(R.id.ly_lmLastName);
        ly_lmstreet = (TextInputLayout) findViewById(R.id.ly_lmStreet);
        ly_lmcity = (TextInputLayout) findViewById(R.id.ly_lmCity);
        ly_lmstate = (TextInputLayout) findViewById(R.id.ly_lmState);
        ly_lmzip = (TextInputLayout) findViewById(R.id.ly_lmZip);
        ly_lmcounty = (TextInputLayout) findViewById(R.id.ly_lmCountry);
        ly_lmphonenumber = (TextInputLayout) findViewById(R.id.ly_lmPhoneNumber);

        btnAdd =(Button) findViewById(R.id.btn_add_library_member);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_add_library_member:
                //Add button calls the membercontroller which has the functionality
                addLibraryMember();
                break;
            default:
                break;
        }
    }

    private void addLibraryMember(){

        String memberId = tv_lmMemberId.getText().toString();
        if (TextUtils.isEmpty(memberId) || memberId.length()<MIN_LENGTH) {
            ly_lmMemberId.setError("please input member id (>"+MIN_LENGTH+" chars)");
            return;
        }

        String firstName = tv_lmFirstName.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            ly_lmfirstName.setError("please input first name");
            return;
        }

        String lastName = tv_lmLastName.getText().toString();
        if (TextUtils.isEmpty(lastName)) {
            ly_lmlastName.setError("please input last name");
            return;
        }

        String street = tv_lmStreet.getText().toString();
        if (TextUtils.isEmpty(street)) {
            ly_lmstreet.setError("please input street");
            return;
        }

        String state = tv_lmState.getText().toString();
        if (TextUtils.isEmpty(state)) {
            ly_lmstate.setError("please input state");
            return;
        }

        String city  = tv_lmCity.getText().toString();
        if (TextUtils.isEmpty(city)) {
            ly_lmcity.setError("please input city");
            return;
        }

        String zip = tv_lmZip.getText().toString();
        if (TextUtils.isEmpty(zip)) {
            ly_lmzip.setError("please input zip");
            return;
        }

        String country = tv_lmCountry.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            ly_lmcounty.setError("please input country");
            return;
        }

        String phoneNumber = tv_lmPhoneNumber.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            ly_lmphonenumber.setError("please input phone number");
            return;
        }

        HashMap<String, String> values = new HashMap<>();
        values.put("memberid", memberId);
        values.put("firstname", firstName);
        values.put("lastname", lastName);
        values.put("street", street);
        values.put("state", state);
        values.put("city", city);
        values.put("zip", zip);
        values.put("country", country);
        values.put("phone", phoneNumber);

        MemberController memberController = new MemberController();
        String newMemberId = "";
        try {
            newMemberId = memberController.addLibraryMember(UserInfoMgr.getInstance().getUser(), values);
            // TODO: if newMemberId exist already, we need to show that it was unsuccessful
            if(newMemberId!=null){
                tv_lmStatus.setVisibility(View.VISIBLE);
                tv_lmStatus.setTextColor(getResources().getColor(R.color.color_blue));
                tv_lmStatus.setText("Member ID : "+newMemberId);
                clearAllFieds(); // Clear out all values so you can add a new member
            }
        } catch (Exception e){
            tv_lmStatus.append(e.getMessage());
        } finally {
            memberController = null;
            values.clear();
        }

    }

    private void clearAllFieds() {
        tv_lmMemberId.getText().clear();
        tv_lmFirstName.getText().clear();
        tv_lmLastName.getText().clear();
        tv_lmStreet.getText().clear();
        tv_lmState.getText().clear();
        tv_lmZip.getText().clear();
        tv_lmCountry.getText().clear();
        tv_lmPhoneNumber.getText().clear();
        tv_lmCity.getText().clear();


    }
}
