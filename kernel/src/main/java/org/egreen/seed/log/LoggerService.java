package org.egreen.seed.log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dewmal on 3/21/15.
 */
public class LoggerService implements Logger {


    /**
     * Logger
     */
    private List<Logger> loggers = new ArrayList<Logger>();


    @Override
    public String getName() {
        return null;
    }

    @Override
    public void log(Type type, Object message) {
        for (Logger logger : loggers) {
            logger.log(type, message);
        }
    }


    /**
     * Register New Logger
     *
     * @param logger
     */
    public void registerLogger(Logger logger) {
        loggers.add(logger);
    }

    /**
     * Remove Logger
     *
     * @param logger
     */
    public void unRegisterLogger(Logger logger) {
        loggers.remove(logger);
    }
}
