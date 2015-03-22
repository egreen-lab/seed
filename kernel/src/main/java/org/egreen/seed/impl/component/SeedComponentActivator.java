package org.egreen.seed.impl.component;

import org.egreen.seed.api.adaptivity.FeatureRepo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dewmal on 3/21/15.
 */
public interface SeedComponentActivator extends BundleActivator, FeatureRepo {

    InputStream componentConfiguration() throws IOException;

    void beforeStart(BundleContext bundleContext) throws Exception;

    void afterStart(BundleContext bundleContext) throws Exception;
}
