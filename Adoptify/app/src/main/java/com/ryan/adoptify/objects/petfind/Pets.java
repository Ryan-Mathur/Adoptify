
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pets {

        @SerializedName("pet")
        @Expose
        private List<Pet> pet = null;

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
        public Pets(List<Pet> pet) {
            super();
            this.pet = pet;
        }

        public List<Pet> getPet() {
            return pet;
        }

        public void setPet(List<Pet> pet) {
            this.pet = pet;
        }

        public Pets withPet(List<Pet> pet) {
            this.pet = pet;
            return this;
        }

    }
