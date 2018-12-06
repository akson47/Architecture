package com.androidarchitectureproject.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.androidarchitectureproject.api.ApiService;
import com.androidarchitectureproject.model.PostModel;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by @yaksonn on 22.3.2018.
 */

@Singleton
public class PostRepository {

    public  MutableLiveData<ArrayList<PostModel>> getPostList(){
        final MutableLiveData<ArrayList<PostModel>> data = new MutableLiveData<>();
        ApiService.apiInterface.getPostList().enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {

            }
        });
        return data;
    }
}
