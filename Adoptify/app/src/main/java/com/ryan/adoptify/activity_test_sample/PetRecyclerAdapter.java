package com.ryan.adoptify.activity_test_sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryan.adoptify.R;

/**
 * Created by Ryan on 5/15/17.
 */

public class PetRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PetVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sample));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

