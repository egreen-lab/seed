package org.egreen.seed.kernel;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 5/6/15.
 */
public class SeedActivator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Working Appasda TEST COPY 2");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stop working ");
    }


}
