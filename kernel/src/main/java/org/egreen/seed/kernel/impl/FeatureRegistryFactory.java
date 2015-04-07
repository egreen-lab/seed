package org.egreen.seed.kernel.impl;

import org.egreen.seed.kernel.FeatureRegistry;
import org.egreen.seed.kernel.feature.Feature;

import java.util.Hashtable;

/**
 * Created by dewmal on 4/5/15.
 */
public class FeatureRegistryFactory {


    private final FeatureRegistry featureRegistry;


    public FeatureRegistry getFeatureRegistry() {
        return featureRegistry;
    }


    private class VMBaseFeatureRegistryImpl implements FeatureRegistry {


        private Hashtable<String, Feature> featureTable;


        public VMBaseFeatureRegistryImpl() {
            featureTable = new Hashtable<String, Feature>();
        }

        @Override
        public void save(String key, Feature feature) {
            featureTable.put(key, feature);
        }

        @Override
        public Feature getFeature(String key) {
            return featureTable.get(key);
        }
    }



    private static FeatureRegistryFactory INSTANCE;
    private FeatureRegistryFactory() {
        featureRegistry = new VMBaseFeatureRegistryImpl();
    }

    public static FeatureRegistryFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FeatureRegistryFactory();
        }
        return INSTANCE;
    }

}
