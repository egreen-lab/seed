package org.egreen.seed.sample2;


import org.egreen.seed.api.adaptivity.FeatureService;
import org.egreen.seed.api.adaptivity.Role;
import org.egreen.seed.api.component.SeedComponent;
import org.egreen.seed.api.log.Logger;
import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.api.log.Type;
import org.egreen.seed.sample.api.HelloWorldAPI;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 3/21/15.
 */
public class Main extends SeedComponent {

    private static Logger logger;
    private FeatureService featureService;

    @Override
    public void beforeStart(BundleContext bundleContext) throws Exception {
        logger = bundleContext.getService(bundleContext.getServiceReference(LoggerService.class));
        featureService = bundleContext.getService(bundleContext.getServiceReference(FeatureService.class));


    }


    @Override
    public void afterStart(BundleContext bundleContext) throws Exception {

        logger.log(Type.INFO, "Working Seri");

        HelloWorldAPI feature = featureService.getFeature(HelloWorldAPI.class, "seed.sample.component", Role.MainRole.ADMIN);
        feature.shakeHand("Hello I am DEWMAL");

    }


}