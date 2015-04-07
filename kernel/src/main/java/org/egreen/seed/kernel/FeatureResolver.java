package org.egreen.seed.kernel;

import org.egreen.seed.kernel.feature.Feature;

/**
 * Created by dewmal on 4/5/15.
 */
public interface FeatureResolver<T> {

    T resolveFeature(Feature feature);

}
