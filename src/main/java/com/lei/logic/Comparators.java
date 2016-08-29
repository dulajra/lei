package com.lei.logic;

import com.MongoEntities.ProductEntity;
import com.MongoEntities.TypeEntity;
import com.utils.MongoTemplate;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by anuradhawick on 8/29/16.
 */
public class Comparators {
    static MongoOperations ops = MongoTemplate.getOperator();

    // obtaining the cheapest item give the type
    public static ProductEntity getCheapest(TypeEntity type) {
        List<ProductEntity> productEntities = ops.
                find(Query.query(Criteria.where("typeEntity").
                                is(type)).
                                with(new Sort(new Sort.Order(Sort.Direction.ASC, "price")))
                        , ProductEntity.class);
        return productEntities.get(0);
    }

    // obtaining details of an item
    public static ProductEntity getProduct(String name) {
        return ops.find(Query.query(Criteria.where("name").regex("(" + name + ")")), ProductEntity.class).get(0);
    }

    // obtain detail list for comparision
    public static List<ProductEntity> getProducts(String typeName) {

        TypeEntity typeEntity = ops.find(Query.query(Criteria.
                        where("name").
                        regex(typeName)),
                TypeEntity.class).get(0);

        return ops.find(Query.query(Criteria.where("typeEntity").
                        is(typeEntity)).
                        with(new Sort(Sort.Direction.ASC, "price")),
                ProductEntity.class);
    }
}
