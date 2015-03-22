package org.egreen.seed.api.component;

import org.egreen.seed.api.adaptivity.Feature;
import org.egreen.seed.api.adaptivity.FeatureKey;
import org.egreen.seed.api.adaptivity.FeatureService;
import org.osgi.framework.BundleContext;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Every Seed Components Have to Extend By this
 * Created by dewmal on 3/21/15.
 */
public abstract class SeedComponent implements SeedComponentActivator {
    private final Map<String, Class> features = new HashMap();


    private FeatureService featureService;
    private BundleContext bundleContext;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        beforeStart(bundleContext);
        featureService = bundleContext.getService(bundleContext.getServiceReference(FeatureService.class));
        featureService.registerFeatures(getFeatures());
        afterStart(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }

    protected void registerFeature(Class Class) {
        features.put(Class.getName(), Class);

    }

    @Override
    public Map<String, Class> getFeatures() {
        return features;
    }
}
