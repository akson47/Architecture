package com.androidarchitectureproject.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.androidarchitectureproject.R;
import com.androidarchitectureproject.api.ApiErrorUtils;
import com.androidarchitectureproject.api.ApiService;
import com.androidarchitectureproject.helper.DialogHelper;
import com.androidarchitectureproject.model.UserModel;
import com.androidarchitectureproject.viewmodel.UserProfileViewModel;

import java.util.HashMap;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class UserProfileFragment extends BaseFragment {

    @BindView(R.id.userFullnameTextView) TextView userFullnameTextView;

    private UserProfileViewModel userProfileViewModel;

    public UserProfileFragment() {}

    public static UserProfileFragment newInstance(int userId) {
        Bundle args = new Bundle();
        args.putInt("userId", userId);
        UserProfileFragment fragment = new UserProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int userId = getArguments().getInt("userId", 1);
        userProfileViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        userProfileViewModel.init(userId);
        userProfileViewModel.getUser().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                // update UI
                userFullnameTextView.setText(userModel.getName());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
