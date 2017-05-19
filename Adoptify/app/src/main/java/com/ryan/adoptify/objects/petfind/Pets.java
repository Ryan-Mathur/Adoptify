
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pets {

    @SerializedName("pet")
    @Expose
    private Pet pet;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pets() {
    }

    /**
     * 
     * @param pet
     */
    public Pets(Pet pet) {
        super();
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pets withPet(Pet pet) {
        this.pet = pet;
        return this;
    }

}
