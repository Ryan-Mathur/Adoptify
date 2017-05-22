package com.ryan.adoptify.objects.petfind.customexclusions;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.ryan.adoptify.objects.petfind.Option;
import com.ryan.adoptify.objects.petfind.Options;

/**
 * Created by Ryan on 5/19/17.
 */

public class CustomExclusionFactory implements ExclusionStrategy{
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return (f.getDeclaringClass() == Options.class);
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
