package com.ryan.adoptify.activity_test_sample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryan.adoptify.R;
import com.ryan.adoptify.interfaces.PetFindInterface;
import com.ryan.adoptify.objects.petfind.Animal;
import com.ryan.adoptify.objects.petfind.Breed;
import com.ryan.adoptify.objects.petfind.BreedTypeAdapter;
import com.ryan.adoptify.objects.petfind.Pet;
import com.ryan.adoptify.objects.petfind.PetFindObject;
import com.ryan.adoptify.objects.petfind.Petfinder;
import com.ryan.adoptify.objects.petfind.Pets;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SampleActivity extends AppCompatActivity {
    public static String mLocation;
    private static final String TAG = "SampleActivity";
    public static final String API_KEY = "162b9e49bc224d56fd2fce3b079b49d5";
    public static final String JSON_FORMAT = "json";
    public static final String BASE_URL = "http://api.petfinder.com/";
    public static final String LOCATION = "21157";
    public static final String ANIMAL = "dog";


    private TextView mNameView;
    private PetRecyclerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Log.d(TAG, "Getting PetFinder info");
        //mLocation = "21157";

        mNameView = (TextView) findViewById(R.id.text1);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .registerTypeAdapter(Breed.class,new BreedTypeAdapter())
                    .create();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            Log.d(TAG, "onGson: " + retrofit.toString());

            PetFindInterface findPetService = retrofit.create(PetFindInterface.class);
            final Call<PetFindObject> petFindObject = findPetService.searchPet(API_KEY,JSON_FORMAT,LOCATION);


            petFindObject.enqueue(new Callback<PetFindObject>() {
                @Override
                public void onResponse(Call<PetFindObject> call, Response<PetFindObject> response) {
                    Petfinder petFindInterface = response.body().getPetfinder();

                    if(petFindInterface == null){
                        Toast.makeText(SampleActivity.this, "This is null", Toast.LENGTH_SHORT).show();
                    }
                    Log.d(TAG, "onResponse: "+response);
                    mNameView.setText(petFindInterface.getPets().getPet().get(1).getName().get$t());

                }

                @Override
                public void onFailure(Call<PetFindObject> call, Throwable t) {
                    Log.d(TAG, "onFailure: PetFinder API call Failed");
                    t.printStackTrace();
                    Toast.makeText(SampleActivity.this, "Unable to load data from PetFinder", Toast.LENGTH_SHORT).show();
                }

            });
        } else {
            Toast.makeText(SampleActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }

    }
        }

