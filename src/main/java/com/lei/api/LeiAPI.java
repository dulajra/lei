package com.lei.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by anuradhawick on 8/30/16.
 */
@Path("/")
public class LeiAPI {
    @GET
    @Path("/add")
    public Response getMsg() {
        return Response.status(200).entity("success").build();
    }
}
