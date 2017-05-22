package com.ryan.adoptify;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryan.adoptify.activity_test_sample.PetRecyclerAdapterTest;
import com.ryan.adoptify.constants.PetFinderAPI;
import com.ryan.adoptify.interfaces.PetFindInterface;
import com.ryan.adoptify.objects.petfind.Breed;
import com.ryan.adoptify.objects.petfind.Pet;
import com.ryan.adoptify.objects.petfind.PetFindObject;
import com.ryan.adoptify.objects.petfind.Petfinder;
import com.ryan.adoptify.objects.petfind.customexclusions.CustomExclusionFactory;
import com.ryan.adoptify.objects.petfind.objecttypeadapters.BreedTypeAdapter;
import com.ryan.adoptify.recyclerview.PetRecyclerAdapter;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private PetRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Getting PetFinder info");


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .registerTypeAdapter(Breed.class,new BreedTypeAdapter())
                    //.registerTypeAdapter(Options.class,new OptionsTypeAdapter())
                    .setExclusionStrategies(new CustomExclusionFactory())
                    .create();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(PetFinderAPI.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            PetFindInterface findPetService = retrofit.create(PetFindInterface.class);
            Call<PetFindObject> petFindObject = findPetService.searchPet(PetFinderAPI.API_KEY,
                    PetFinderAPI.JSON_FORMAT,PetFinderAPI.LOCATION);


            petFindObject.enqueue(new Callback<PetFindObject>() {
                @Override
                public void onResponse(Call<PetFindObject> call, Response<PetFindObject> response) {
                    Petfinder petFindInterface = response.body().getPetfinder();

                    if(petFindInterface == null){
                        Toast.makeText(MainActivity.this, "This is null", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Found results!", Toast.LENGTH_SHORT).show();
                    }
                    //mNameView.setText(petFindInterface.getPets().getPet().get(1).getName().get$t());
                    mAdapter.newPetSearchList(petFindInterface.getPets().getPet());

                }

                @Override
                public void onFailure(Call<PetFindObject> call, Throwable t) {
                    Log.d(TAG, "onFailure: PetFinder API call Failed");
                    t.printStackTrace();
                    Toast.makeText(MainActivity.this, "Unable to load data from PetFinder", Toast.LENGTH_SHORT).show();
                }

            });
        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }



        //setting up the recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        //because we are running an asynctask in the background, we don't know WHEN we are going to get
        //the list to give to the recycler adapter. So here, I'm just giving it an empty list, as a placeholder.
        mAdapter = new PetRecyclerAdapter(new ArrayList<Pet>());

        //more setup for the recycler view
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);

    }
}
