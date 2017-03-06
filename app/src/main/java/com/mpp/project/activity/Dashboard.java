package com.mpp.project.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mpp.project.R;

public class Dashboard extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public static Intent getIntentToMe(Context context) {
        Intent intent = new Intent(context, Dashboard.class);
        return intent;
    }
}
