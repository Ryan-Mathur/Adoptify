package com.ryan.adoptify.objects.petfind.objecttypeadapters;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ryan.adoptify.objects.petfind.Breed;
import com.ryan.adoptify.objects.petfind.Option;
import com.ryan.adoptify.objects.petfind.Options;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ryan on 5/19/17.
 */

public class OptionsTypeAdapter extends TypeAdapter<Options> {

    private Gson gson = new Gson();

    @Override
    public void write(JsonWriter out, Options value) throws IOException {
        gson.toJson(value,Options.class,out);
    }

    @Override
    public Options read(JsonReader in) throws IOException {
        Options Options;

        // in.beginObject();
        // in.nextName();

        if (in.peek() == JsonToken.BEGIN_ARRAY) {
            Options = new Options((Options[]) gson.fromJson(in, Options[].class));
        } else if(in.peek() == JsonToken.BEGIN_OBJECT) {
            Options = new Options(String.valueOf(gson.fromJson(in, Options.class)));
        } else {
            throw new JsonParseException("Unexpected token " + in.peek());
        }


        // in.endObject();
        return Options;
    }
}
