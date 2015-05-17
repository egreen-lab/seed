package org.egreen.seed.transport.http;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dewmal on 5/17/15.
 */
public class JerseyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> result = new HashSet<Class<?>>();
        result.add(StatusResource.class);
        return result;
    }

}
