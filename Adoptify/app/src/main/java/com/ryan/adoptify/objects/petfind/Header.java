
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {

    @SerializedName("timestamp")
    @Expose
    private Timestamp timestamp;
    @SerializedName("status")
    @Expose
    private Status_ status;
    @SerializedName("version")
    @Expose
    private Version version;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Header() {
    }

    /**
     * 
     * @param timestamp
     * @param status
     * @param version
     */
    public Header(Timestamp timestamp, Status_ status, Version version) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.version = version;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Header withTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Status_ getStatus() {
        return status;
    }

    public void setStatus(Status_ status) {
        this.status = status;
    }

    public Header withStatus(Status_ status) {
        this.status = status;
        return this;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Header withVersion(Version version) {
        this.version = version;
        return this;
    }

}
