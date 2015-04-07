package org.egreen.seed.kernel;

import org.egreen.seed.kernel.impl.FeatureRegistryFactory;
import org.egreen.seed.kernel.impl.SeedTrackerImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 4/5/15.
 */
public class SeedMain implements BundleActivator {


    private SeedTracker seedTrackerCustomizer;

    @Override
    public void start(BundleContext bundleContext) throws Exception {

        // Tracking Seed Components
        seedTrackerCustomizer = new SeedTrackerImpl(bundleContext);
        seedTrackerCustomizer.start();


        //Register Feature Registry

        FeatureRegistryFactory featureRegistryFactory = FeatureRegistryFactory.getInstance();
        bundleContext.registerService(FeatureRegistryFactory.class.getName(), featureRegistryFactory, null);

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        seedTrackerCustomizer.stop();
    }
}
