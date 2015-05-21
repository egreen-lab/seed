package org.egreen.seed.transport.http;

/**
 * Created by dewmal on 5/17/15.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
@Path("status")
public class StatusResource {

    @GET
    @Produces("application/json")
    public Response getStatus() {
        Map<String,String> stringMap=new HashMap<String,String> ();
        stringMap.put("A","TEST");
        return Response.status(200).entity("{Message:'TEST'}").build();
    }
}