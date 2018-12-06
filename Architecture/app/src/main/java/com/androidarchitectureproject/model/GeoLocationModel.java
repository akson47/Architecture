package com.androidarchitectureproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class GeoLocationModel {

    @SerializedName("lat")
    private String latitude;
    @SerializedName("lng")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
