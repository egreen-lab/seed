package org.egreen.seed.impl.log;

import org.egreen.seed.api.log.Logger;
import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.api.log.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dewmal on 3/21/15.
 */
public class LoggerServiceImpl implements LoggerService {


    /**
     * Logger
     */
    private List<Logger> loggers = new ArrayList<Logger>();


    @Override
    public String getName() {
        return null;
    }

    @Override
    public void log(Type type, Object... message) {
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
