package com.example.khanh.customlistview;

/**
 * Created by khanh on 06/07/2016.
 */
public class Country {
    private String countryName;
    private String flagName;
    private int population;

    public Country(String countryName, String flagName, int population) {
        this.countryName = countryName;
        this.flagName = flagName;
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return this.countryName + " (population: " + this.population + ")";
    }
}
