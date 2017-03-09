package com.mpp.project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mpp.project.R;

import java.util.HashMap;

public class Memebers extends BaseActivity implements View.OnClickListener{
    private Button btnAddLibraryMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memebers);
        btnAddLibraryMember = (Button) findViewById(R.id.btn_add_library_members);
        btnAddLibraryMember.setOnClickListener(this);

    }
    // TODO: Should go to addupdatecontroller
    private HashMap<String, String> getLibraryMemberInfo(){
        HashMap<String, String> values = new HashMap<>();
        values.put("name",null);
        return values;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_admin:
                //startActivity(Book.getIntentToMe(Dashboard.this));
                break;
            case R.id.btn_add_librarian:
                //loginOut();
                break;
            case R.id.btn_add_library_members:
                Intent i = new Intent(this, AddMember.class);
                startActivity(i);
                break;
            default:
                break;
        }
//        case R.id,lim){
//            new HashMap<>()
//                    contoller.addlibr(admin, hashmap)
//        }
    }
}
