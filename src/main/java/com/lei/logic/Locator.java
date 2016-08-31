package com.lei.logic;

import com.MongoEntities.LocationEntity;
import com.MongoEntities.ProductEntity;
import com.MongoEntities.TypeEntity;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by anuradhawick on 8/30/16.
 */
public class Locator {
    static MongoOperations ops = MongoTemplate.getOperator();

    // find the location of a given item type
    public static LocationEntity getLocationByType(String typeName) {
        TypeEntity typeEntity = ops.find(Query.query(Criteria.where("name").
                        regex("[" + typeName + "]")),
                TypeEntity.class).get(0);
        List<LocationEntity> locationEntities = typeEntity.getLocations();
        // TODO for the time being this supports only one location
        return locationEntities.get(0);
    }

    // find the location given the item
    public static LocationEntity getLocationByItem(String itemName) {
        ProductEntity productEntity = ops.find(Query.query(Criteria.where("name").
                        regex("[" + itemName + "]")),
                ProductEntity.class).get(0);

        List<LocationEntity> locationEntities = productEntity.getTypeEntity().getLocations();
        // TODO for the time being this supports only one location
        return locationEntities.get(0);
    }
}
