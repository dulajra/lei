package com.lei.api;

import Beans.ProductsJaxBean;
import com.MongoEntities.LocationEntity;
import com.MongoEntities.TypeEntity;
import com.utils.GenericTemplate;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by anuradhawick on 9/4/16.
 */
@Path("/product-management")
public class ProductManagement {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericTemplate getMessage(final ProductsJaxBean input) {
        MongoOperations ops = MongoTemplate.getOperator();
        // if the type available add the product
        TypeEntity type = ops.find(Query.query(Criteria.where("name").regex(input.productType)), TypeEntity.class).get(0);
        if (type == null) {
            type = new TypeEntity();
            type.setName(input.productType);
            LocationEntity location = ops.find(Query.query(Criteria.where("name").regex(input.location.getName())), LocationEntity.class).get(0);
            if (location == null) {
                ops.save(input.location);
            }
            type.getLocations().add(location);
            ops.save(type);
        } else {
            LocationEntity location = ops.find(Query.query(Criteria.where("name").regex(input.location.getName())), LocationEntity.class).get(0);
            if (location == null) {
                ops.save(input.location);
            }
            type.setLocations(new ArrayList<LocationEntity>());
            type.getLocations().add(location);
            ops.save(type);
        }
        return new GenericTemplate();
    }
}
