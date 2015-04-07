package org.egreen.seed.kernel.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.egreen.seed.kernel.FeatureGrabber;
import org.egreen.seed.kernel.FeatureRegistry;
import org.egreen.seed.kernel.SeedTracker;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.BundleTrackerCustomizer;

import java.net.URL;
import java.util.Enumeration;

/**
 * Created by dewmal on 4/5/15.
 */
public class SeedTrackerImpl implements BundleTrackerCustomizer, SeedTracker {

    private static final Log LOG = LogFactory.getLog(SeedTrackerImpl.class);

    private final BundleTracker seedTracker;


    private final FeatureRegistry featureRegistry;


    public SeedTrackerImpl(BundleContext bundleContext) {
        seedTracker = new BundleTracker(bundleContext, Bundle.INSTALLED, this);
        // Get Feature Registry
        featureRegistry = FeatureRegistryFactory.getInstance().getFeatureRegistry();
    }

    @Override
    public Object addingBundle(Bundle bundle, BundleEvent event) {

        LOG.info("working start");
        FeatureGrabber featureGrabber=new XMLFeatureGrabber(bundle);
        featureGrabber.bindFeatureRegistry(featureRegistry);
        featureGrabber.getFeatures();
        LOG.info("working end");

        return null;
    }

    @Override
    public void modifiedBundle(Bundle bundle, BundleEvent event, Object object) {

    }

    @Override
    public void removedBundle(Bundle bundle, BundleEvent event, Object object) {

    }


    @Override
    public void start() {
        seedTracker.open();
    }

    @Override
    public void stop() {
        seedTracker.close();
    }
}
