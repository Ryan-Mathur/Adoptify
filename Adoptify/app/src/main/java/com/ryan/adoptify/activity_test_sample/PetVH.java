package com.ryan.adoptify.activity_test_sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ryan.adoptify.R;

public class PetVH extends RecyclerView.ViewHolder{
    public TextView mName;

    public PetVH(View itemView) {
        super(itemView);
        mName = (TextView) itemView.findViewById(R.id.textView);
    }
}
