package org.egreen.seed.api.adaptivity;

import org.egreen.seed.impl.component.config.model.ComponentConfig;

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
     * @param <F>
     * @param feature
     * @param featureKey
     * @param role       @return
     */
    <F extends Feature<? extends FeatureKey>> F getFeature(Class<F> feature, String featureKey, Role role) throws Exception;

//    /**
//     * Accessing Features
//     * <p/>
//     * Role Help to provide better security coverage for features
//     *
//     * @param <F>
//     * @param feature
//     * @param role
//     * @return
//     */
//    <F extends Feature<? extends FeatureKey>> F getFeature(Class<F> feature, Role role) throws Exception;


    /**
     * Initializing Component
     *
     * @param configuration
     */
    void bind(ComponentConfig configuration);
}
