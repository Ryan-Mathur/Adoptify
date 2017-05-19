
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Breeds {

    @SerializedName("breed")
    @Expose
    private Breed breed;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Breeds() {
    }

    /**
     * 
     * @param breed
     */
    public Breeds(Breed breed) {
        super();
        this.breed = breed;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Breeds withBreed(Breed breed) {
        this.breed = breed;
        return this;
    }

}
