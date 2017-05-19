
package com.ryan.adoptify.objects.petfind; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pet {

    @SerializedName("options")
    @Expose
    private Options options;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("age")
    @Expose
    private Age age;
    @SerializedName("size")
    @Expose
    private Size size;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("shelterPetId")
    @Expose
    private ShelterPetId shelterPetId;
    @SerializedName("breeds")
    @Expose
    private Breeds breeds;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("sex")
    @Expose
    private Sex sex;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("mix")
    @Expose
    private Mix mix;
    @SerializedName("shelterId")
    @Expose
    private ShelterId shelterId;
    @SerializedName("lastUpdate")
    @Expose
    private LastUpdate lastUpdate;
    @SerializedName("animal")
    @Expose
    private Animal animal;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pet() {
    }

    /**
     * 
     * @param sex
     * @param status
     * @param lastUpdate
     * @param breeds
     * @param contact
     * @param mix
     * @param size
     * @param id
     * @param shelterPetId
     * @param shelterId
     * @param description
     * @param age
     * @param name
     * @param media
     * @param animal
     * @param options
     */
    public Pet(Options options, Status status, Contact contact, Age age, Size size, Media media, Id id, ShelterPetId shelterPetId, Breeds breeds, Name name, Sex sex, Description description, Mix mix, ShelterId shelterId, LastUpdate lastUpdate, Animal animal) {
        super();
        this.options = options;
        this.status = status;
        this.contact = contact;
        this.age = age;
        this.size = size;
        this.media = media;
        this.id = id;
        this.shelterPetId = shelterPetId;
        this.breeds = breeds;
        this.name = name;
        this.sex = sex;
        this.description = description;
        this.mix = mix;
        this.shelterId = shelterId;
        this.lastUpdate = lastUpdate;
        this.animal = animal;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Pet withOptions(Options options) {
        this.options = options;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pet withStatus(Status status) {
        this.status = status;
        return this;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Pet withContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Pet withAge(Age age) {
        this.age = age;
        return this;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Pet withSize(Size size) {
        this.size = size;
        return this;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Pet withMedia(Media media) {
        this.media = media;
        return this;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Pet withId(Id id) {
        this.id = id;
        return this;
    }

    public ShelterPetId getShelterPetId() {
        return shelterPetId;
    }

    public void setShelterPetId(ShelterPetId shelterPetId) {
        this.shelterPetId = shelterPetId;
    }

    public Pet withShelterPetId(ShelterPetId shelterPetId) {
        this.shelterPetId = shelterPetId;
        return this;
    }

    public Breeds getBreeds() {
        return breeds;
    }

    public void setBreeds(Breeds breeds) {
        this.breeds = breeds;
    }

    public Pet withBreeds(Breeds breeds) {
        this.breeds = breeds;
        return this;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Pet withName(Name name) {
        this.name = name;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Pet withSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Pet withDescription(Description description) {
        this.description = description;
        return this;
    }

    public Mix getMix() {
        return mix;
    }

    public void setMix(Mix mix) {
        this.mix = mix;
    }

    public Pet withMix(Mix mix) {
        this.mix = mix;
        return this;
    }

    public ShelterId getShelterId() {
        return shelterId;
    }

    public void setShelterId(ShelterId shelterId) {
        this.shelterId = shelterId;
    }

    public Pet withShelterId(ShelterId shelterId) {
        this.shelterId = shelterId;
        return this;
    }

    public LastUpdate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LastUpdate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Pet withLastUpdate(LastUpdate lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Pet withAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }

}
