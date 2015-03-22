package org.egreen.seed.adaptivitiy;

import org.egreen.seed.api.adaptivity.Feature;
import org.egreen.seed.api.adaptivity.FeatureKey;
import org.egreen.seed.api.adaptivity.FeatureService;
import org.egreen.seed.api.adaptivity.Role;
import org.osgi.framework.BundleContext;

import java.util.Map;

/**
 * Created by dewmal on 3/21/15.
 */
public class FeatureServiceManager implements FeatureService {

    private final BundleContext bundleContext;

    public FeatureServiceManager(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }


    @Override
    public void registerFeature(Class<Feature<? extends FeatureKey>> featureClass, String key) {

    }

    @Override
    public <F extends Feature<? extends FeatureKey>> Feature getFeature(FeatureKey featureKey, Role role) {
        return null;
    }

    @Override
    public void registerFeatures(Map<String, Class<Feature<? extends FeatureKey>>> features) {

    }


}
