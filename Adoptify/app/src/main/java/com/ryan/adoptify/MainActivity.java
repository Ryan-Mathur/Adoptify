package com.ryan.adoptify;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryan.adoptify.constants.PetFinderAPI;
import com.ryan.adoptify.interfaces.PetFindInterface;
import com.ryan.adoptify.objects.petfind.Breed;
import com.ryan.adoptify.objects.petfind.Pet;
import com.ryan.adoptify.objects.petfind.PetFindObject;
import com.ryan.adoptify.objects.petfind.Petfinder;
import com.ryan.adoptify.objects.petfind.customexclusions.CustomExclusionFactory;
import com.ryan.adoptify.objects.petfind.objecttypeadapters.BreedTypeAdapter;
import com.ryan.adoptify.recyclerview.PetRecyclerAdapter;
import com.ryan.adoptify.singleton.Singleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private static final String TAG = "MainActivity";
    public static final int REQUEST_LOCATION = 10;
    private static final int REQUEST_CHECK_SETTINGS = 11;
    private String mLocation;
    private EditText mLocationInput;
    private PetRecyclerAdapter mAdapter;
    private Button mSearchButton;
    private ImageButton mCurrentLocation;
    protected Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private Double mLong, mLat;
    private TextView petLocation;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Getting PetFinder info");

        mLocationInput = (EditText) findViewById(R.id.searchLocation);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mCurrentLocation = (ImageButton) findViewById(R.id.currentLocation);


        //setting up the recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        //because we are running an asynctask in the background, we don't know WHEN we are going to get
        //the list to give to the recycler adapter. So here, I'm just giving it an empty list, as a placeholder.
        mAdapter = new PetRecyclerAdapter(new ArrayList<Pet>());

        //more setup for the recycler view
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);

        //setOnClickListener for getting the current zip code which will use location services
        mCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
        // call a api from yelp when click on the search button
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(MainActivity.this)
                    .addConnectionCallbacks(MainActivity.this)
                    .addOnConnectionFailedListener(MainActivity.this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }


    private void search() {
        if (mLocationInput == null) {
            Toast.makeText(this, "Please Enter A Zip Code", Toast.LENGTH_SHORT).show();

        } else {
            mLocation = mLocationInput.getText().toString().trim();
        }

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .registerTypeAdapter(Breed.class, new BreedTypeAdapter())
                    //.registerTypeAdapter(Options.class,new OptionsTypeAdapter())
                    .setExclusionStrategies(new CustomExclusionFactory())
                    .create();

            //uncomment below and client in retrofit to view log of request
           /* HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor).build();*/

            Retrofit retrofit = new Retrofit.Builder()
                    //.client(client)
                    .baseUrl(PetFinderAPI.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            PetFindInterface findPetService = retrofit.create(PetFindInterface.class);
            Call<PetFindObject> petFindObject = findPetService.searchPet(PetFinderAPI.API_KEY,
                    PetFinderAPI.JSON_FORMAT, PetFinderAPI.COUNT, mLocation);


            petFindObject.enqueue(new Callback<PetFindObject>() {
                @Override
                public void onResponse(Call<PetFindObject> call, Response<PetFindObject> response) {
                    Petfinder petFindInterface = response.body().getPetfinder();


                    try {
                        mAdapter.newPetSearchList(petFindInterface.getPets().getPet());
                    } catch (NullPointerException e) {
                        Toast.makeText(MainActivity.this, "No results please make sure your zip code is valid", Toast.LENGTH_SHORT).show();
                    } finally {
                        try {
                            for (int i = 0; i < petFindInterface.getPets().getPet().size(); i++) {
                                Singleton.getInstance().setPetsCache().add(i, petFindInterface.getPets());
                            }
                        } catch (NullPointerException e) {
                            Toast.makeText(MainActivity.this, "No results please make sure your zip code is valid", Toast.LENGTH_SHORT).show();
                        } finally {

                        }
                    }
                }

                    @Override
                    public void onFailure (Call < PetFindObject > call, Throwable t){
                        Log.d(TAG, "onFailure: PetFinder API call Failed");
                        t.printStackTrace();
                        Toast.makeText(MainActivity.this, "Unable to load data from PetFinder", Toast.LENGTH_SHORT).show();
                    }

                });
            } else{
                Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
            }

        }


        //location

    private void getLocation() {


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);
        } else {
            //comment code out since it does nothing intention was to check if location is turned on but isn't working
//            LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
//
//            PendingResult<LocationSettingsResult> result =
//                    LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
//
//            result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
//                @Override
//                public void onResult(LocationSettingsResult result) {
//                    final Status status = result.getStatus();
//                    final LocationSettingsStates state = result.getLocationSettingsStates();
//                    switch (status.getStatusCode()) {
//                        case LocationSettingsStatusCodes.SUCCESS:
//                            // All location settings are satisfied. The client can initialize location
//                            // requests here.
//
//                            break;
//                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//                            // Location settings are not satisfied. But could be fixed by showing the user
//                            // a dialog.
//                            try {
//                                // Show the dialog by calling startResolutionForResult(),
//                                // and check the result in onActivityResult().
//                                status.startResolutionForResult(
//                                        MainActivity.this,
//                                        REQUEST_CHECK_SETTINGS);
//                            } catch (IntentSender.SendIntentException e) {
//                                // Ignore the error.
//                            }
//                            break;
//                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                            // Location settings are not satisfied. However, we have no way to fix the
//                            // settings so we won't show the dialog.
//
//                            break;
//                    }
//                }
//            });


            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);


            if (lastLocation == null) {

                LocationRequest locationRequest = LocationRequest.create()
                        .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, this);


            } else {
                mLat = lastLocation.getLatitude();
                mLong = lastLocation.getLongitude();
                //Toast.makeText(this, ""+mLat+"&"+mLong, Toast.LENGTH_SHORT).show();
            }
        }

        Geocoder geocoder = new Geocoder(this, Locale.US);


        try {
            if (mLat == null && mLong == null) {
                Toast.makeText(this, "Please make sure your location is turned on", Toast.LENGTH_SHORT).show();
                return;
            } else {
                //Place your latitude and longitude
                List<Address> addresses = geocoder.getFromLocation(mLat, mLong, 1);


                if (addresses != null) {

                    String fetchedAddress = addresses.get(0).getPostalCode();

                    mLocationInput.setText(fetchedAddress);

                } else
                    mLocationInput.setText("No location found..!");

            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Could not get address..!", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
    }

    //comment code out since it does nothing intention was to check if location is turned on
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        Log.d("onActivityResult()", Integer.toString(resultCode));
//
//        final LocationSettingsStates states = LocationSettingsStates.fromIntent(data);
//        switch (requestCode)
//        {
//            case REQUEST_LOCATION:
//                switch (resultCode)
//                {
//                    case Activity.RESULT_OK:
//                    {
//                        // All required changes were successfully made
//                        Toast.makeText(MainActivity.this, "Location enabled by user!", Toast.LENGTH_LONG).show();
//                        break;
//                    }
//                    case Activity.RESULT_CANCELED:
//                    {
//                        // The user was asked to change settings, but chose not to
//                        Toast.makeText(MainActivity.this, "Location not enabled, user cancelled.", Toast.LENGTH_LONG).show();
//                        break;
//                    }
//                    default:
//                    {
//                        break;
//                    }
//                }
//                break;
//        }
//    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "You said no, how could you??", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}


