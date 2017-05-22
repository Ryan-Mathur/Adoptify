package com.ryan.adoptify.activity_test_sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ryan.adoptify.R;
import com.ryan.adoptify.objects.petfind.Pet;

import java.util.List;

/**
 * Created by Ryan on 5/15/17.
 */

public class PetRecyclerAdapterTest extends RecyclerView.Adapter<PetVHTest>{
    private List<Pet> mPetsList;

    public PetRecyclerAdapterTest(List<Pet> petsList) {
        mPetsList = petsList;
    }

    @Override
    public PetVHTest onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PetVHTest(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(PetVHTest holder, int position) {
        Pet currentPet = mPetsList.get(position);
        holder.mName.setText(currentPet.getName().get$t());


    }

    @Override
    public int getItemCount() {
        return mPetsList.size();
    }

    public void newPetSearchList(List<Pet> newList){
        mPetsList = newList;
        notifyDataSetChanged();
    }
}

