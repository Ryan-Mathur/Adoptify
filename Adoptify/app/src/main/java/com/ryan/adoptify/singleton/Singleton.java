package com.ryan.adoptify.singleton;

import com.ryan.adoptify.objects.petfind.Pets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 5/24/17.
 */

public class Singleton {

    private List<Pets> mPetsCache;

    public static Singleton sInstance;

    public static Singleton getInstance() {
        if(sInstance == null){
            sInstance = new Singleton();
        }
        return sInstance;
    }

    private Singleton() {
        mPetsCache = new ArrayList<>();
    }

    public List<Pets> getPetsCache() {
        return mPetsCache;
    }
    public List<Pets> setPetsCache() {return mPetsCache;}

}
