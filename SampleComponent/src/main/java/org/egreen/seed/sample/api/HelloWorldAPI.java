package org.egreen.seed.sample.api;

import org.egreen.seed.api.adaptivity.Feature;
import org.egreen.seed.api.adaptivity.impl.BasicFeatureKey;

/**
 * Created by dewmal on 3/22/15.
 */
public interface HelloWorldAPI extends Feature<BasicFeatureKey> {

    void shakeHand(String message);
}
