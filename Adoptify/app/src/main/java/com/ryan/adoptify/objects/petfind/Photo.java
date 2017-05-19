
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("@size")
    @Expose
    private String size;
    @SerializedName("$t")
    @Expose
    private String $t;
    @SerializedName("@id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Photo() {
    }

    /**
     * 
     * @param id
     * @param $t
     * @param size
     */
    public Photo(String size, String $t, String id) {
        super();
        this.size = size;
        this.$t = $t;
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Photo withSize(String size) {
        this.size = size;
        return this;
    }

    public String get$t() {
        return $t;
    }

    public void set$t(String $t) {
        this.$t = $t;
    }

    public Photo with$t(String $t) {
        this.$t = $t;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Photo withId(String id) {
        this.id = id;
        return this;
    }

}
