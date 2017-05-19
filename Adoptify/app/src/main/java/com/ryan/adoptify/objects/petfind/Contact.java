
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("phone")
    @Expose
    private Phone phone;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("address2")
    @Expose
    private Address2 address2;
    @SerializedName("email")
    @Expose
    private Email email;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("zip")
    @Expose
    private Zip zip;
    @SerializedName("fax")
    @Expose
    private Fax fax;
    @SerializedName("address1")
    @Expose
    private Address1 address1;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Contact() {
    }

    /**
     * 
     * @param zip
     * @param phone
     * @param fax
     * @param email
     * @param state
     * @param address1
     * @param address2
     * @param city
     */
    public Contact(Phone phone, State state, Address2 address2, Email email, City city, Zip zip, Fax fax, Address1 address1) {
        super();
        this.phone = phone;
        this.state = state;
        this.address2 = address2;
        this.email = email;
        this.city = city;
        this.zip = zip;
        this.fax = fax;
        this.address1 = address1;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Contact withPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Contact withState(State state) {
        this.state = state;
        return this;
    }

    public Address2 getAddress2() {
        return address2;
    }

    public void setAddress2(Address2 address2) {
        this.address2 = address2;
    }

    public Contact withAddress2(Address2 address2) {
        this.address2 = address2;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Contact withEmail(Email email) {
        this.email = email;
        return this;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Contact withCity(City city) {
        this.city = city;
        return this;
    }

    public Zip getZip() {
        return zip;
    }

    public void setZip(Zip zip) {
        this.zip = zip;
    }

    public Contact withZip(Zip zip) {
        this.zip = zip;
        return this;
    }

    public Fax getFax() {
        return fax;
    }

    public void setFax(Fax fax) {
        this.fax = fax;
    }

    public Contact withFax(Fax fax) {
        this.fax = fax;
        return this;
    }

    public Address1 getAddress1() {
        return address1;
    }

    public void setAddress1(Address1 address1) {
        this.address1 = address1;
    }

    public Contact withAddress1(Address1 address1) {
        this.address1 = address1;
        return this;
    }

}
