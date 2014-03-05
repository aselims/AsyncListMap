package org.aselims.testapp.helpers;

//POJO

/**
 * Created by aselims on 03/03/14.
 */
public class PlaceData {
    private String name;
    private String place;
    private String pictureUrl;

    public PlaceData(String name, String place, String pictureUrl) {
        super();
        this.name = name;
        this.place = place;
        this.pictureUrl = pictureUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPicture(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
