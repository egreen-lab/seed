package org.egreen.seed.console;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Validate;

/**
 * Created by dewmal on 4/8/15.
 */
@Component
@Provides
@Instantiate
public class SeedConsole {

    private static final Log LOGGER = LogFactory.getLog(SeedConsole.class);

    @Validate
    void start() {
        LOGGER.info("Console Working");
    }

}
