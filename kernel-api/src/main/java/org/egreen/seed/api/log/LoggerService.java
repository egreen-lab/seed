package org.egreen.seed.api.log;

/**
 * Created by dewmal on 3/21/15.
 */
public interface LoggerService extends Logger {


    /**
     * Register New Logger
     *
     * @param logger
     */
    public void registerLogger(Logger logger);

    /**
     * Remove Logger
     *
     * @param logger
     */
    public void unRegisterLogger(Logger logger);
}
