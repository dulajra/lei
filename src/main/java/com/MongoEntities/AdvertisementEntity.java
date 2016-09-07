package com.MongoEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by anuradhawick on 9/6/16.
 */
@Document(collection = "advertisement")
public class AdvertisementEntity {

    @Id
    private String id;

    private String encodedImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }
}
