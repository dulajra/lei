package com;

import com.MongoEntities.ProductEntity;
import com.MongoEntities.TypeEntity;
import com.lei.logic.Comparators;
import com.lei.logic.Finder;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;

/**
 * Created by anuradhawick on 8/30/16.
 */
public class test {
    public static void main(String[] args) {
        MongoOperations ops = MongoTemplate.getOperator();
        TypeEntity ty = ops.find(Query.query(Criteria.where("name").regex("(soap)")),TypeEntity.class).get(0);
        ProductEntity ety = ops.find(Query.query(Criteria.where("typeEntity").is(ty)),ProductEntity.class).get(0);
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("soap");
        TypeEntity typeEntity = Finder.findType(arr);
        System.out.println(typeEntity.getName());
    }
}
