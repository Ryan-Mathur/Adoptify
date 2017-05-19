
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Breed {

    @SerializedName("$t")
    @Expose
    private String $t;

    /**
     * No args constructor for use in serialization
     *
     */
    public Breed() {
    }

    /**
     * 
     * @param $t
     */
    public Breed(String $t) {
        super();
        this.$t = $t;
    }

    public Breed(Breed[] breeds) {
        
    }


    public String get$t() {
        return $t;
    }

    public void set$t(String $t) {
        this.$t = $t;
    }

    public Breed with$t(String $t) {
        this.$t = $t;
        return this;
    }

}
