package com;

import com.MongoEntities.ProductEntity;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by anuradhawick on 8/30/16.
 */
public class test {
    public static void main(String[] args) {
        MongoOperations ops = MongoTemplate.getOperator();
        ProductEntity ety = ops.find(Query.query(Criteria.where("name").regex("lux")), ProductEntity.class).get(0);
        System.out.println(ety.getName());
    }
}
