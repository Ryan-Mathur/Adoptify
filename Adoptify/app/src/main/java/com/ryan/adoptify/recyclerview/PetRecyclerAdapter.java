package com.ryan.adoptify.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ryan.adoptify.R;
import com.ryan.adoptify.objects.petfind.Pet;
import com.ryan.adoptify.objects.petfind.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Ryan on 5/22/17.
 */

public class PetRecyclerAdapter extends RecyclerView.Adapter<com.ryan.adoptify.recyclerview.PetVH>{
    private List<Pet> mPetsList;

    public PetRecyclerAdapter(List<Pet> petsList) {
        mPetsList = petsList;
    }

    @Override
    public com.ryan.adoptify.recyclerview.PetVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new com.ryan.adoptify.recyclerview.PetVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.maincustom_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(com.ryan.adoptify.recyclerview.PetVH holder, int position) {
        Pet currentPet = mPetsList.get(position);
        holder.mName.setText(currentPet.getName().get$t());
        if (!currentPet.getMedia().getPhotos().getPhoto().isEmpty()) {
            Picasso.with(holder.mPetImage.getContext()).load(
                    currentPet.getMedia().getPhotos().getPhoto().get(0).get$t()
            )
                    .resize(200, 200).into(holder.mPetImage);

        } else {
            holder.mPetImage.setImageResource(R.drawable.no_image_found);
        }

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
