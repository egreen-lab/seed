package org.egreen.seed;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.felix.ipojo.annotations.*;
import org.egreen.seed.api.monitor.ServiceMonitor;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 3/21/15.
 */
@Component
@Instantiate
public class Main {

    private static final Log LOG= LogFactory.getLog(Main.class);

    @Context
    private BundleContext bundleContext;


    @Requires
    private ServiceMonitor serviceMonitor;


    @Validate
    void start() {

        LOG.info("Start Seed");

        bundleContext.addServiceListener(serviceMonitor);


        ServiceTest serviceTest = new ServiceTest();
        bundleContext.registerService(ServiceTest.class, serviceTest, null);
    }
}
