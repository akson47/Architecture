package com.androidarchitectureproject.api;

import com.androidarchitectureproject.model.PostModel;
import com.androidarchitectureproject.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public interface ApiInterface {

    @GET(ApiEndPoints.API_GET_ALL_USERS)
    Call<ArrayList<UserModel>> getAllUsers();

    @GET(ApiEndPoints.API_GET_ALL_USERS + "/{id}")
    Call<UserModel> getUserById(@Path("id") int userId);

    @GET(ApiEndPoints.API_GET_ALL_POSTS)
    Call<ArrayList<PostModel>> getPostList();

    @GET(ApiEndPoints.API_GET_ALL_POSTS + "/{id}")
    Call<PostModel> getPostById(@Path("id") int postId);

}

