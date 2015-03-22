package org.egreen.seed.log;


import org.egreen.seed.api.log.Logger;
import org.egreen.seed.api.log.Type;

/**
 * Created by dewmal on 3/21/15.
 */
public class DefaultLogger implements Logger {


    private final String name;

    public DefaultLogger(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public void log(Type type, Object message) {
        System.out.print(getName());
        System.out.print("\t");
        System.out.print(type + " - " + message);
    }
}
