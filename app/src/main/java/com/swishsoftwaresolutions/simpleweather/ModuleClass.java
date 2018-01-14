package com.swishsoftwaresolutions.simpleweather;

/**
 * Created by DELL on 1/13/2018.
 */

public class ModuleClass {
    int id;
    String city;
    String updated_details;
    String details;
    String temperature;

    public ModuleClass(){

    }

    public ModuleClass(int id, String city, String updated_details, String details, String temperature) {
        this.id = id;
        this.city = city;
        this.updated_details = updated_details;
        this.details = details;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdated_details() {
        return updated_details;
    }

    public void setUpdated_details(String updated_details) {
        this.updated_details = updated_details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
