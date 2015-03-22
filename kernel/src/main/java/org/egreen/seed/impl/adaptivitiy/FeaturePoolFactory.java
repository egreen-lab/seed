package org.egreen.seed.impl.adaptivitiy;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.egreen.seed.api.adaptivity.Feature;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 3/22/15.
 */
public class FeaturePoolFactory extends BaseKeyedPooledObjectFactory<String, Feature> {


    private BundleContext bundleContext;

    public FeaturePoolFactory(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    @Override
    public Feature create(String className) throws Exception {

        Bundle[] bundles = bundleContext.getBundles();
        Class<?> featureClass = null;
        for (Bundle bundle : bundles) {
            try {
                featureClass = bundle.loadClass(className);
            } catch (Exception e) {

            }
        }
        if (featureClass == null)
            return null;

        return (Feature) featureClass.newInstance();
    }

    @Override
    public PooledObject<Feature> wrap(Feature value) {
        return new DefaultPooledObject<Feature>(value);
    }
}
