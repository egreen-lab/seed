package org.egreen.seed;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;

/**
 * Created by dewmal on 4/24/15.
 */
@Component
@Instantiate
public class ServiceTest {

    private static final Log LOG = LogFactory.getLog(ServiceTest.class);

    public void helloServer(String name) {
        LOG.info(name);
    }
}
