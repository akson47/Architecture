package com.androidarchitectureproject.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidarchitectureproject.R;
import com.androidarchitectureproject.adapter.PostsRecyclerAdapter;
import com.androidarchitectureproject.interfaces.RecyclerItemClickListener;
import com.androidarchitectureproject.model.PostModel;
import com.androidarchitectureproject.viewmodel.PostsViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsActivity extends BaseActivity {

    @BindView(R.id.postsRecyclerView) RecyclerView postsRecyclerView;

    private ArrayList<PostModel> postList = new ArrayList<>();
    private PostsViewModel postsViewModel;
    private PostsRecyclerAdapter postsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        ButterKnife.bind(this);
        initRecyclerView();
        initViewModel();
    }

    private void initViewModel(){
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.loadPostList();
        postsViewModel.getPostList().observe(this, new Observer<ArrayList<PostModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<PostModel> postModels) {
                postList.clear();
                postList.addAll(postModels);
                postsRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initRecyclerView(){
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        postsRecyclerAdapter = new PostsRecyclerAdapter(postList, new RecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        postsRecyclerView.setAdapter(postsRecyclerAdapter);
    }
}
