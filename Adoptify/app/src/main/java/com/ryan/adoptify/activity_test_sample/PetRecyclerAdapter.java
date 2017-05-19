package com.ryan.adoptify.activity_test_sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ryan.adoptify.R;
import com.ryan.adoptify.objects.petfind.Pet;
import com.ryan.adoptify.objects.petfind.PetFindObject;
import com.ryan.adoptify.objects.petfind.Pets;

import java.util.List;

/**
 * Created by Ryan on 5/15/17.
 */

public class PetRecyclerAdapter extends RecyclerView.Adapter<PetVH>{
    private List<Pet> mPetsList;

    public PetRecyclerAdapter(List<Pet> petsList) {
        mPetsList = petsList;
    }

    @Override
    public PetVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PetVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sample, parent, false));
    }

    @Override
    public void onBindViewHolder(PetVH holder, int position) {
        Pet currentPet = mPetsList.get(position);
        holder.mName.setText((CharSequence) currentPet.getId());


    }


    @Override
    public int getItemCount() {
        return mPetsList.size();
    }

}

