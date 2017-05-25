package com.ryan.adoptify;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryan.adoptify.constants.Constants;
import com.ryan.adoptify.constants.PetFinderAPI;
import com.ryan.adoptify.interfaces.PetFindInterface;
import com.ryan.adoptify.objects.petfind.Breed;
import com.ryan.adoptify.objects.petfind.Pet;
import com.ryan.adoptify.objects.petfind.PetFindObject;
import com.ryan.adoptify.objects.petfind.Petfinder;
import com.ryan.adoptify.objects.petfind.Pets;
import com.ryan.adoptify.objects.petfind.customexclusions.CustomExclusionFactory;
import com.ryan.adoptify.objects.petfind.objecttypeadapters.BreedTypeAdapter;
import com.ryan.adoptify.recyclerview.PetRecyclerAdapter;
import com.ryan.adoptify.singleton.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private TextView detailName;
    private int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        mId = intent.getIntExtra(Constants.PET_ID_TO_DETAILS,0);
        detailName = (TextView) findViewById(R.id.detailPetName);
        detailName.setText(Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getName().get$t());

    }
}


