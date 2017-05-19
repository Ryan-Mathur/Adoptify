
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Petfinder {

    @SerializedName("@xmlns:xsi")
    @Expose
    private String xmlnsXsi;
    @SerializedName("lastOffset")
    @Expose
    private LastOffset lastOffset;
    @SerializedName("pets")
    @Expose
    private Pets pets;
    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("@xsi:noNamespaceSchemaLocation")
    @Expose
    private String xsiNoNamespaceSchemaLocation;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Petfinder() {
    }

    /**
     * 
     * @param lastOffset
     * @param xmlnsXsi
     * @param pets
     * @param xsiNoNamespaceSchemaLocation
     * @param header
     */
    public Petfinder(String xmlnsXsi, LastOffset lastOffset, Pets pets, Header header, String xsiNoNamespaceSchemaLocation) {
        super();
        this.xmlnsXsi = xmlnsXsi;
        this.lastOffset = lastOffset;
        this.pets = pets;
        this.header = header;
        this.xsiNoNamespaceSchemaLocation = xsiNoNamespaceSchemaLocation;
    }

    public String getXmlnsXsi() {
        return xmlnsXsi;
    }

    public void setXmlnsXsi(String xmlnsXsi) {
        this.xmlnsXsi = xmlnsXsi;
    }

    public Petfinder withXmlnsXsi(String xmlnsXsi) {
        this.xmlnsXsi = xmlnsXsi;
        return this;
    }

    public LastOffset getLastOffset() {
        return lastOffset;
    }

    public void setLastOffset(LastOffset lastOffset) {
        this.lastOffset = lastOffset;
    }

    public Petfinder withLastOffset(LastOffset lastOffset) {
        this.lastOffset = lastOffset;
        return this;
    }

    public Pets getPets() {
        return pets;
    }

    public void setPets(Pets pets) {
        this.pets = pets;
    }

    public Petfinder withPets(Pets pets) {
        this.pets = pets;
        return this;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Petfinder withHeader(Header header) {
        this.header = header;
        return this;
    }

    public String getXsiNoNamespaceSchemaLocation() {
        return xsiNoNamespaceSchemaLocation;
    }

    public void setXsiNoNamespaceSchemaLocation(String xsiNoNamespaceSchemaLocation) {
        this.xsiNoNamespaceSchemaLocation = xsiNoNamespaceSchemaLocation;
    }

    public Petfinder withXsiNoNamespaceSchemaLocation(String xsiNoNamespaceSchemaLocation) {
        this.xsiNoNamespaceSchemaLocation = xsiNoNamespaceSchemaLocation;
        return this;
    }

}
