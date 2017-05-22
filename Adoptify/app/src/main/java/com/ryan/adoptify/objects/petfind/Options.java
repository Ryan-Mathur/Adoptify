
package com.ryan.adoptify.objects.petfind; ;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Options {

    @SerializedName("option")
    @Expose
    private List<Option> option = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Options() {
    }

    /**
     *
     * @param option
     */
    public Options(List<Option> option) {
        super();
        this.option = option;
    }


    public Options(Options[] optionses) {

    }

    public Options(Object s) {

    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

    public Options withOption(List<Option> option) {
        this.option = option;
        return this;
    }

}
