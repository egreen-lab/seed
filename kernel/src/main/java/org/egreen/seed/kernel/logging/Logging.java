package org.egreen.seed.kernel.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;

/**
 * Created by dewmal on 5/19/15.
 */
public class Logging extends ConsoleHandler {


    @Override
    public void publish(LogRecord record) {

        System.out.println(record);
    }
}
