package com.example.demo.json;

/**
 * Created by DEMO on 05-10-2016.
 */

import com.google.gson.annotations.SerializedName;
        import java.util.ArrayList;
        import java.util.List;
        import com.google.gson.annotations.Expose;

public class CountryPopulation {

    @SerializedName("worldpopulation")
    @Expose
    private ArrayList<Worldpopulation> worldpopulation = new ArrayList<Worldpopulation>();

    /**
     * @return The worldpopulation
     */
    public ArrayList<Worldpopulation> getWorldpopulation() {
        return worldpopulation;
    }

    /**
     * @param worldpopulation The worldpopulation
     */
    public void setWorldpopulation(ArrayList<Worldpopulation> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }
}



