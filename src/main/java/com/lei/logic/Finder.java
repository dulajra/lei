package com.lei.logic;

import com.MongoEntities.ProductEntity;
import com.MongoEntities.TypeEntity;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by anuradhawick on 8/31/16.
 */
public class Finder {
    private static MongoOperations ops = MongoTemplate.getOperator();

    public static ProductEntity findProduct(List<String> productList) {
        if (productList == null)
            return null;
        for (String product : productList) {
            if (ops.count(Query.query(Criteria.where("name").regex("(" + product + ")")), ProductEntity.class) > 0) {
                return ops.find(Query.query(Criteria.where("name").regex("(" + product + ")")), ProductEntity.class).get(0);
            }
        }
        return null;
    }

    public static TypeEntity findType(List<String> typeList) {
        if (typeList == null)
            return null;
        for (String product : typeList) {
            if (ops.count(Query.query(Criteria.where("name").regex("(" + product + ")")), TypeEntity.class) > 0) {
                return ops.find(Query.query(Criteria.where("name").regex("(" + product + ")")), TypeEntity.class).get(0);
            }
        }
        return null;
    }
}
