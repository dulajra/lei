package com.MongoEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by anuradhawick on 9/4/16.
 */
@Document(collection = "marketData")
public class MarketData {
    @Id
    private String id;

//    private
}
