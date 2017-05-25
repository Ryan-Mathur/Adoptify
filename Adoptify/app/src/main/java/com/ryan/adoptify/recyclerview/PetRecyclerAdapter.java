package com.ryan.adoptify.recyclerview;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryan.adoptify.DetailActivity;
import com.ryan.adoptify.R;
import com.ryan.adoptify.constants.Constants;
import com.ryan.adoptify.objects.petfind.Pet;
import com.ryan.adoptify.objects.petfind.Pets;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Ryan on 5/22/17.
 */

public class PetRecyclerAdapter extends RecyclerView.Adapter<PetVH>{
    private List<Pet> mPetsList;
    public int mPosition;


    public PetRecyclerAdapter(List<Pet> petsList) {
        mPetsList = petsList;
    }

    @Override
    public PetVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PetVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_custom_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final PetVH holder, final int position) {
        final Pet currentPet = mPetsList.get(position);
        holder.mName.setText(currentPet.getName().get$t());
        if (!currentPet.getMedia().getPhotos().getPhoto().isEmpty()) {
            Picasso.with(holder.mPetImage.getContext()).load(
                    currentPet.getMedia().getPhotos().getPhoto().get(0).get$t()
            )
                    .resize(200, 200).into(holder.mPetImage);

        } else {
            holder.mPetImage.setImageResource(R.drawable.no_image_found);
        }

        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPosition = mPetsList.indexOf(currentPet);
                Intent intent = new Intent(v.getContext().getApplicationContext(),DetailActivity.class);
                intent.putExtra(Constants.PET_ID_TO_DETAILS, holder.getAdapterPosition());
                Log.d(TAG, "onClick: intent data" + String.valueOf(currentPet));
                v.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mPetsList.size();
    }

    public void newPetSearchList(List<Pet> newList){
        mPetsList = newList;
        Log.d(TAG, "newPetSearchList: " + mPetsList.size());
        notifyDataSetChanged();
    }
}
