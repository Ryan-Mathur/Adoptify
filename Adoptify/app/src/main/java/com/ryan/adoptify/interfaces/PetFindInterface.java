package com.ryan.adoptify.interfaces;

import com.ryan.adoptify.objects.petfind.PetFindObject;

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
                                  @Query("location") String location,
                                  @Query("count") String count);
}
