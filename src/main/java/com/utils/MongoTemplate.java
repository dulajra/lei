package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Obtain the mongo template for mongo db access
 *
 * @author anuradhawick
 */
public class MongoTemplate {
    private static ApplicationContext ctx = new GenericXmlApplicationContext("SpringMongo.xml");

    public static MongoOperations getOperator() {
        return (MongoOperations) ctx.getBean("mongoTemplate");
    }
}
