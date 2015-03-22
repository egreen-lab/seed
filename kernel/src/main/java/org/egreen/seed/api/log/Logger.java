package org.egreen.seed.api.log;

/**
 * Created by dewmal on 3/21/15.
 */
public interface Logger {


    String getName();

    /**
     * Log message
     *
     * @param type
     * @param message
     */
    public void log(Type type, Object... message);

}
