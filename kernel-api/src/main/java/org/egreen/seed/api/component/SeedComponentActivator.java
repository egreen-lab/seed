package org.egreen.seed.api.component;

import org.egreen.seed.api.adaptivity.FeatureRepo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 3/21/15.
 */
public interface SeedComponentActivator extends BundleActivator, FeatureRepo {

    void beforeStart(BundleContext bundleContext) throws Exception;

    void afterStart(BundleContext bundleContext) throws Exception;
}
