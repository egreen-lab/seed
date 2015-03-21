package org.egreen.seed.log;

/**
 * Created by dewmal on 3/21/15.
 */
public interface Logger {


    public String getName();

    /**
     * Log message
     *
     * @param type
     * @param message
     */
    public void log(Type type, Object message);

}
