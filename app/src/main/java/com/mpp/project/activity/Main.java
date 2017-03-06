package com.mpp.project.activity;

import android.os.Bundle;
import android.view.View;

import com.mpp.project.R;

public class Main extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Dashboard.getIntentToMe(Main.this));
            }
        });
    }
}
