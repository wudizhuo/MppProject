package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import com.mpp.project.CheckoutRecordAdapter;
import com.mpp.project.R;
import com.mpp.project.business.LibraryMember;
import com.mpp.project.dataaccess.DataAccessFacade;

public class CheckoutRecordActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int memberId = getIntent().getIntExtra("memberId", -1);
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        LibraryMember member = (LibraryMember) dataAccessFacade.readPerson(memberId);
        if (member == null) {
            Toast.makeText(this, "Don't have this member", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setContentView(R.layout.activity_checkout_record);
        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(new CheckoutRecordAdapter(this, member.getCheckoutRecord().getEntries()));
    }

    public static Intent getIntentToMe(Context context, int memberId) {
        Intent intent = new Intent(context, CheckoutRecordActivity.class);
        intent.putExtra("memberId", memberId);
        return intent;
    }
}
