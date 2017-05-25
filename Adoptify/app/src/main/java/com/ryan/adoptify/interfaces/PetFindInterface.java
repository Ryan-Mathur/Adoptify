package com.ryan.adoptify.interfaces;

import android.widget.EditText;

import com.ryan.adoptify.objects.petfind.PetFindObject;
import com.ryan.adoptify.objects.petfind.Petfinder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ryan on 5/17/17.
 */

public interface PetFindInterface {

    @GET("pet.find")
    Call<PetFindObject> searchPet(@Query("key") String apiKey,
                                  @Query("format")String format,
                                  @Query("location") String location);

    @GET("pet.get")
    Call<Petfinder> getSelectedPet(@Query("key") String apiKey,
                                   @Query("format")String format,
                                   @Query("id") String id);
}
