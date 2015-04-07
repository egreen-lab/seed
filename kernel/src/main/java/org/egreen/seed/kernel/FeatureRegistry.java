package org.egreen.seed.kernel;

import org.egreen.seed.kernel.feature.Feature;

import java.util.Map;

/**
 * Created by dewmal on 4/5/15.
 */
public interface FeatureRegistry  {

    /**
     *
     *
     * @param key
     * @param feature
     */
    void save(String key, Feature feature);

    /**
     *
     * @param key
     * @return
     */
    Feature getFeature(String key);
}
