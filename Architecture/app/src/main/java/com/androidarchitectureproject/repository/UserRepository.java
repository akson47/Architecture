package com.androidarchitectureproject.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.androidarchitectureproject.api.ApiService;
import com.androidarchitectureproject.model.UserModel;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class UserRepository {

    public static LiveData<UserModel> getUser(int userId){
        final MutableLiveData<UserModel> data = new MutableLiveData<>();
        ApiService.apiInterface.getUserById(userId).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
        return data;
    }
}
