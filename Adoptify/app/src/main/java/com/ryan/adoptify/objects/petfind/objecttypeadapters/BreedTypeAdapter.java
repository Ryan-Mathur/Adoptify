package com.ryan.adoptify.objects.petfind.objecttypeadapters;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ryan.adoptify.objects.petfind.Breed;

import java.io.IOException;

/**
 * Created by Ryan on 5/19/17.
 */

public class BreedTypeAdapter extends TypeAdapter<Breed>{

    private Gson gson = new Gson();

    @Override
    public void write(JsonWriter out, Breed value) throws IOException {
        gson.toJson(value,Breed.class,out);
    }

    @Override
    public Breed read(JsonReader in) throws IOException {
        Breed Breed;

       // in.beginObject();
       // in.nextName();

        if (in.peek() == JsonToken.BEGIN_ARRAY) {
            Breed = new Breed((Breed[]) gson.fromJson(in, Breed[].class));
        } else if(in.peek() == JsonToken.BEGIN_OBJECT) {
            Breed = new Breed(String.valueOf(gson.fromJson(in, Breed.class)));
        } else {
            throw new JsonParseException("Unexpected token " + in.peek());
        }

       // in.endObject();
        return Breed;
    }
}
