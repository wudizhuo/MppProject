package com.mpp.project.activity;

import android.os.Bundle;
import android.view.View;

import com.mpp.project.R;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class Main extends BaseActivity {
    @InjectView(R.id.btn_login)
    public View loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Dashboard.getIntentToMe(Main.this));
            }
        });
    }
}
