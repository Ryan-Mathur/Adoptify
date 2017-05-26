package com.ryan.adoptify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryan.adoptify.constants.Constants;
import com.ryan.adoptify.objects.petfind.objecttypeadapters.BreedTypeAdapter;
import com.ryan.adoptify.singleton.Singleton;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private TextView detailName,detailAnimal,detailDescription,detailStatus,detailBreed,
            detailSex,detailPhone,detailEmail,detailState,detailCity,detailZip;
    private int mId;
    private ImageView detailImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailName = (TextView) findViewById(R.id.detailPetName);
        detailAnimal = (TextView) findViewById(R.id.detailAnimal);
        detailImage = (ImageView) findViewById(R.id.detailImage);
        detailDescription = (TextView) findViewById(R.id.detailDescription);
        detailStatus = (TextView) findViewById(R.id.detailStatus);
        detailSex = (TextView) findViewById(R.id.detailSex);
        detailPhone = (TextView) findViewById(R.id.detailPhone);
        detailEmail = (TextView) findViewById(R.id.detailEmail);
        detailState = (TextView) findViewById(R.id.detailState);
        detailCity = (TextView) findViewById(R.id.detailCity);
        detailZip = (TextView) findViewById(R.id.detailZip);
        detailBreed = (TextView) findViewById(R.id.detailBreed);



        Intent intent = getIntent();
        mId = intent.getIntExtra(Constants.PET_ID_TO_DETAILS,0);

        detailName.setText(String.format("%s %s",
                getResources().getString(R.string.pet_name),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getName().get$t()));

        detailAnimal.setText(String.format("%s %s",
                getResources().getString(R.string.animal_type),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getAnimal().get$t()));

        detailDescription.setText(String.format("%s %s",
                getResources().getString(R.string.pet_description),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getDescription().get$t()));

        if(Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getStatus().get$t().contains("A")){
            detailStatus.setText(String.format("%s %s",
                    getResources().getString(R.string.adoptable),getResources().getString(R.string.available)));
        }else {
            detailStatus.setText(String.format("%s %s",
                    getResources().getString(R.string.adoptable),getResources().getString(R.string.not_available)));
    }

        detailSex.setText(String.format("%s %s",
                getResources().getString(R.string.sex),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getSex().get$t()));

        detailPhone.setText(String.format("%s %s",
                getResources().getString(R.string.phone),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getContact().getPhone().get$t()));

        detailEmail.setText(String.format("%s %s",
                getResources().getString(R.string.email),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getContact().getEmail().get$t()));

        detailState.setText(String.format("%s %s",
                getResources().getString(R.string.state),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getContact().getState().get$t()));

        detailCity.setText(String.format("%s %s",
                getResources().getString(R.string.city),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getContact().getCity().get$t()));

        detailZip.setText(String.format("%s %s",
                getResources().getString(R.string.zip),
                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getContact().getZip().get$t()));

//comment out breeds due to data not parsing correctly
//        detailBreed.setText(String.format("%s %s",
//                getResources().getString(R.string.breed),
//                Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getBreeds().getBreed().get$t()));


        if (!Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getMedia().getPhotos().getPhoto().isEmpty()) {
            Picasso.with(detailImage.getContext()).load(
                    Singleton.getInstance().getPetsCache().get(mId).getPet().get(mId).getMedia().getPhotos().getPhoto().get(0).get$t()
            )
                  .resize(400,400).into(detailImage);

        } else {
            detailImage.setImageResource(R.drawable.no_image_found);
        }

    }
}


