
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Email {

    @SerializedName("$t")
    @Expose
    private String $t;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Email() {
    }

    /**
     * 
     * @param $t
     */
    public Email(String $t) {
        super();
        this.$t = $t;
    }

    public String get$t() {
        return $t;
    }

    public void set$t(String $t) {
        this.$t = $t;
    }

    public Email with$t(String $t) {
        this.$t = $t;
        return this;
    }

}
