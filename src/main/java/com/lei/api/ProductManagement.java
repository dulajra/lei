package com.lei.api;

import Beans.ProductsJaxBean;
import com.MongoEntities.LocationEntity;
import com.MongoEntities.ProductEntity;
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
        TypeEntity type = null;
        if (ops.find(Query.query(Criteria.where("name").regex(input.productType)), TypeEntity.class).size() > 0) {
            type = ops.find(Query.query(Criteria.where("name").regex(input.productType)), TypeEntity.class).get(0);
        }
        if (type == null) {
            type = new TypeEntity();
            type.setName(input.productType);
            LocationEntity location = null;
            if (ops.find(Query.query(Criteria.where("name").regex(input.location.getName())), LocationEntity.class).size() > 0) {
                ops.find(Query.query(Criteria.where("name").regex(input.location.getName())), LocationEntity.class).get(0);
            }
            if (location == null) {
                location = input.location;
                ops.save(location);
            }
            type.getLocations().add(location);
            ops.save(type);
        } else {
            LocationEntity location = null;
            if (ops.find(Query.query(Criteria.where("name").regex(input.location.getName())), LocationEntity.class).size() > 0) {
                location = ops.find(Query.query(Criteria.where("name").regex(input.location.getName())), LocationEntity.class).get(0);
            }
            if (location == null) {
                location = input.location;
                ops.save(location);
            } else {
                type.setLocations(new ArrayList<LocationEntity>());
                type.getLocations().add(location);
            }
            ops.save(type);
        }
        for (ProductEntity product : input.products) {
            product.setTypeEntity(type);
            System.out.println(type.getId());
            ops.save(product);
        }
        return new GenericTemplate();
    }
}
