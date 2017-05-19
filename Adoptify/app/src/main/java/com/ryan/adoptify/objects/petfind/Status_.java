
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status_ {

    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("code")
    @Expose
    private Code code;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Status_() {
    }

    /**
     * 
     * @param message
     * @param code
     */
    public Status_(Message message, Code code) {
        super();
        this.message = message;
        this.code = code;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Status_ withMessage(Message message) {
        this.message = message;
        return this;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Status_ withCode(Code code) {
        this.code = code;
        return this;
    }

}
