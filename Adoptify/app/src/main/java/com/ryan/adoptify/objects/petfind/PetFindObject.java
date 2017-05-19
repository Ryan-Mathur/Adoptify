
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetFindObject {

    @SerializedName("@encoding")
    @Expose
    private String encoding;
    @SerializedName("@version")
    @Expose
    private String version;
    @SerializedName("petfinder")
    @Expose
    private Petfinder petfinder;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PetFindObject() {
    }

    /**
     * 
     * @param petfinder
     * @param encoding
     * @param version
     */
    public PetFindObject( Petfinder petfinder) {
        super();
        this.encoding = encoding;
        this.version = version;
        this.petfinder = petfinder;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public PetFindObject withEncoding(String encoding) {
        this.encoding = encoding;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public PetFindObject withVersion(String version) {
        this.version = version;
        return this;
    }

    public Petfinder getPetfinder() {
        return petfinder;
    }

    public void setPetfinder(Petfinder petfinder) {
        this.petfinder = petfinder;
    }

    public PetFindObject withPetfinder(Petfinder petfinder) {
        this.petfinder = petfinder;
        return this;
    }

}
