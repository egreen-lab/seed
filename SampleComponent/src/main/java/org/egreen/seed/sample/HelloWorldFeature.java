package org.egreen.seed.sample;

import org.egreen.seed.api.adaptivity.impl.BasicFeature;
import org.egreen.seed.api.adaptivity.impl.BasicFeatureKey;

/**
 * Created by dewmal on 3/22/15.
 */
public class HelloWorldFeature extends BasicFeature<BasicFeatureKey> {


    public HelloWorldFeature() {
        super(new BasicFeatureKey("seed.sample.helloworld"));
    }

    @Override
    public String getName() {
        return "Hello World";
    }

    @Override
    public String getVersion() {
        return "0123";
    }
}
