
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phone {

    @SerializedName("$t")
    @Expose
    private String $t;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Phone() {
    }

    /**
     * 
     * @param $t
     */
    public Phone(String $t) {
        super();
        this.$t = $t;
    }

    public String get$t() {
        return $t;
    }

    public void set$t(String $t) {
        this.$t = $t;
    }

    public Phone with$t(String $t) {
        this.$t = $t;
        return this;
    }

}