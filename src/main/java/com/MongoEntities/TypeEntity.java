package com.MongoEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuradhawick on 8/29/16.
 */
@Document(collection = "type")
public class TypeEntity {
    @Id
    private String Id;
    private String name;
    private List<LocationEntity> locations;

    public TypeEntity() {
        locations = new ArrayList<LocationEntity>();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LocationEntity> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationEntity> locations) {
        this.locations = locations;
    }
}
