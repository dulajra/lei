package com.lei.api;

import com.LanguageUtils.Parser;
import com.lei.ai.Responder;
import com.utils.MessageTemplate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by anuradhawick on 8/30/16.
 */
@Path("/")
public class LeiAPI {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageTemplate getMsg(@QueryParam("query") String query) {
        Parser parser = Parser.getParser();
        Responder responder = Responder.getResponder();
        if (query == null || query.length() == 0) {
            MessageTemplate msg = new MessageTemplate();
            msg.error = true;
            return msg;
        }
        return responder.getResponse(parser.getClassifier(query));
    }
}
