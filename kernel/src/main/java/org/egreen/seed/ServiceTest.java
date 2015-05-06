package org.egreen.seed;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by dewmal on 4/24/15.
 */
public class ServiceTest {

    private static final Log LOG = LogFactory.getLog(ServiceTest.class);

    public void helloServer(String name) {
        LOG.info(name);
    }
}
