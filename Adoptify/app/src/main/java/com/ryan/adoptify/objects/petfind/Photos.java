
package com.ryan.adoptify.objects.petfind; ;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photos {

    @SerializedName("photo")
    @Expose
    private List<Photo> photo = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Photos() {
    }

    /**
     * 
     * @param photo
     */
    public Photos(List<Photo> photo) {
        super();
        this.photo = photo;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public Photos withPhoto(List<Photo> photo) {
        this.photo = photo;
        return this;
    }

}
