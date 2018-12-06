package com.androidarchitectureproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class BaseActivity extends AppCompatActivity {

    public static BaseActivity currentActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setCurrentActivity(this);
    }

    public static void setCurrentActivity(BaseActivity currentActivity) {
        BaseActivity.currentActivity = currentActivity;
    }
}
