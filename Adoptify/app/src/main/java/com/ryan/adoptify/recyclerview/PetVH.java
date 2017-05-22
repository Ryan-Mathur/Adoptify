package com.ryan.adoptify.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryan.adoptify.R;

/**
 * Created by Ryan on 5/22/17.
 */

public class PetVH extends RecyclerView.ViewHolder{
    public TextView mName;
    public ImageView mPetImage;

    public PetVH(View itemView) {
        super(itemView);
        mName = (TextView) itemView.findViewById(R.id.petName);
        mPetImage = (ImageView) itemView.findViewById(R.id.petImage);
    }
}
