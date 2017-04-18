package com.sasi.entity;

import javax.persistence.Embeddable;

/**
 * Created by myelleswarapu on 18-04-2017.
 */
@Embeddable
public class Address {

    private String city;
    private String zip;
    private String area;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
