package org.egreen.seed.impl.log;


import org.egreen.seed.api.log.Logger;
import org.egreen.seed.api.log.Type;

import java.util.Arrays;

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
        return name;
    }

    @Override
    public void log(Type type, Object... message) {
        System.out.println();
        System.out.print(getName());
        System.out.print("\t");
        System.out.print(type + " - " + Arrays.toString(message));
    }
}
