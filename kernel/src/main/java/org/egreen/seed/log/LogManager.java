package org.egreen.seed.log;

/**
 * Created by dewmal on 3/21/15.
 */
public interface LogManager {


    /**
     *
     * Get logger By Class
     *
     * @param aClass
     * @return
     */
    Logger getLogger(Class aClass);


    /**
     *
     * Get logger By Name
     *
     * @param name
     * @return
     */
    Logger getLogger(String name);

    /**
     *
     * Get logger with id
     *
     * @param id
     * @return
     */
    Logger getLogger(long id);

}
