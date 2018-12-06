package com.androidarchitectureproject.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import com.androidarchitectureproject.R;

import com.androidarchitectureproject.fragment.UserProfileFragment;


import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setFragment();
    }

    private void setFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, UserProfileFragment.newInstance(1)).commit();
    }


}
