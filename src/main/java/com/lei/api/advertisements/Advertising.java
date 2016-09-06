package com.lei.api.advertisements;

import com.MongoEntities.AdvertisementEntity;
import com.utils.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anuradhawick on 9/6/16.
 */
@Path("/advertisement-management")
public class Advertising {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add-image")
    @Produces(MediaType.APPLICATION_JSON)
    public AdvertisementEntity addImage(AdvertisementEntity ety) {
        MongoOperations ops = MongoTemplate.getOperator();
        ops.save(ety);
        return ety;
    }

    @GET
    @Path("/get-ads")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdvertisementEntity> getImages() {
        MongoOperations ops = MongoTemplate.getOperator();
        List<AdvertisementEntity> entities = ops.findAll(AdvertisementEntity.class);
        return entities;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete-add")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteAdd(AdvertisementEntity ety) {
        System.out.println(ety.getId());
        MongoOperations ops = MongoTemplate.getOperator();
        ops.remove(ety);
        return true;
    }
}
