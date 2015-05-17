package org.egreen.seed.transport.http;

/**
 * Created by dewmal on 5/17/15.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
@Path("status")
public class StatusResource {

    @GET
    @Produces("application/json")
    public List getStatus() {
        List map=new ArrayList();
        map.add("DEwmal");
        map.add("DEwmal");
        map.add("DEwmal");
        map.add("DEwmal");
        return map;
    }
}