package org.egreen.seed.api.adaptivity;

import java.util.Map;

/**
 * Created by dewmal on 3/21/15.
 */
public interface FeatureService {


    /**
     * Register Feature with Feature Service
     *
     * @param featureClass
     */
    void registerFeature(Class<Feature<? extends FeatureKey>> featureClass, String key);


    /**
     * Accessing Features
     * <p/>
     * Role Help to provide better security coverage for features
     *
     * @param featureKey
     * @param role
     * @param <F>
     * @return
     */
    <F extends Feature<? extends FeatureKey>> Feature getFeature(FeatureKey featureKey, Role role);


    /**
     *
     * @param features
     */
    void registerFeatures(Map<String, Class> features);
}
