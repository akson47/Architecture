package com.androidarchitectureproject.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.androidarchitectureproject.model.PostModel;
import com.androidarchitectureproject.repository.PostRepository;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class PostsViewModel extends ViewModel {

    @Inject PostRepository postRepository;

    private MutableLiveData<ArrayList<PostModel>> postList = new MutableLiveData<>();

    public MutableLiveData<ArrayList<PostModel>> getPostList(){
        return postList;
    }

    public void loadPostList(){
        postList = postRepository.getPostList();
    }
}
