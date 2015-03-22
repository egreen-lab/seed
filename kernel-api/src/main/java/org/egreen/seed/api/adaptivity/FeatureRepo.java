package org.egreen.seed.api.adaptivity;

import java.util.Map;

/**
 * Created by dewmal on 3/21/15.
 */
public interface FeatureRepo {


    /**
     * Get Features
     *
     * @return
     */
    Map<String, Class> getFeatures();
}
