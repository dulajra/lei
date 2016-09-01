package com.utils;

import com.MongoEntities.LocationEntity;
import com.MongoEntities.TypeEntity;

/**
 * Created by anuradhawick on 9/1/16.
 */
public class ProductTemplate {
    private String name;
    private TypeEntity location;
    private Float price;
    private String description;

    public ProductTemplate(String name, TypeEntity typeEntity, Float price, String description) {
        this.name = name;
        this.location = typeEntity;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeEntity getLocation() {
        return location;
    }

    public void setLocation(TypeEntity location) {
        this.location = location;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
