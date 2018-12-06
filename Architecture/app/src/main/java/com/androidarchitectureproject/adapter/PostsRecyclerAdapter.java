package com.androidarchitectureproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidarchitectureproject.R;
import com.androidarchitectureproject.interfaces.RecyclerItemClickListener;
import com.androidarchitectureproject.model.PostModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.ViewHolder> {

    private ArrayList<PostModel> postList = new ArrayList<>();
    private RecyclerItemClickListener recyclerItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.postTitleTextView) TextView postTitleTextView;
        @BindView(R.id.postBodyTextView) TextView postBodyTextView;

        public ViewHolder(final View view, final RecyclerItemClickListener recyclerItemClickListener){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public PostsRecyclerAdapter(ArrayList<PostModel> postList,
                                   RecyclerItemClickListener recyclerItemClickListener) {
        this.postList = postList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_post, parent,false);
        return new ViewHolder(view, recyclerItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.postTitleTextView.setText(postList.get(position).getTitle());
        holder.postBodyTextView.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

}