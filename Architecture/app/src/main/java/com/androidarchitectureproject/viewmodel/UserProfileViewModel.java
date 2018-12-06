package com.androidarchitectureproject.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.androidarchitectureproject.model.UserModel;
import com.androidarchitectureproject.repository.UserRepository;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class UserProfileViewModel extends ViewModel {

    private int userId;
    private LiveData<UserModel> userModel;

    public void init(int userId){
        this.userId = userId;
        userModel = UserRepository.getUser(userId);
    }

    public LiveData<UserModel> getUser(){
        return userModel;
    }
}
