package org.egreen.seed.sample;

import org.egreen.seed.api.adaptivity.impl.BasicFeature;
import org.egreen.seed.api.adaptivity.impl.BasicFeatureKey;
import org.egreen.seed.api.log.Logger;
import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.api.log.Type;
import org.egreen.seed.sample.api.HelloWorldAPI;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 3/22/15.
 */
public class HelloWorldFeature extends BasicFeature<BasicFeatureKey> implements HelloWorldAPI {

    private Logger logger;


    public HelloWorldFeature() {
        super(new BasicFeatureKey("seed.sample.helloworld", Main.ID));
    }

    @Override
    public void onCreate(BundleContext context) {
        logger = getService(LoggerService.class);
    }

    @Override
    public String getName() {
        return "Hello World";
    }

    @Override
    public String getVersion() {
        return "0123";
    }

    @Override
    public void shakeHand(String message) {
        logger.log(Type.INFO, message + ",  Ok I am HELLO WORLD FEATURE ");

    }
}
