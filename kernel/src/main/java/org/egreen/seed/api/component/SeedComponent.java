package org.egreen.seed.api.component;

import org.egreen.seed.api.adaptivity.FeatureService;
import org.egreen.seed.api.log.Logger;
import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.api.log.Type;
import org.egreen.seed.impl.component.SeedComponentActivator;
import org.egreen.seed.impl.component.config.XMLBasedComponentResolver;
import org.egreen.seed.impl.component.config.model.ComponentConfig;
import org.egreen.seed.impl.utils.Constants;
import org.osgi.framework.BundleContext;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Every Seed Components Have to Extend By this
 * Created by dewmal on 3/21/15.
 */
public abstract class SeedComponent implements SeedComponentActivator {
    private static Logger logger;

    private final Map<String, Class> features = new HashMap();


    private FeatureService featureService;
    private BundleContext bundleContext;

    // Init Component Configurations
    private ComponentConfig configuration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        logger = bundleContext.getService(bundleContext.getServiceReference(LoggerService.class));
        this.bundleContext = bundleContext;
        beforeStart(bundleContext);
        featureService = bundleContext.getService(bundleContext.getServiceReference(FeatureService.class));


        configuration = new XMLBasedComponentResolver().getComponentConfiguration(this);


        featureService.bind(configuration);
        afterStart(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }

    private void registerFeature(Class Class) {
        features.put(Class.getName(), Class);

    }

    @Override
    public Map<String, Class> getFeatures() {
        return features;
    }

    @Override
    public InputStream componentConfiguration() throws IOException {
        URL resource = bundleContext.getBundle().getResource(Constants.SEED_COMPONENT_CONFIG);
        logger.log(Type.INFO, resource);
        return resource.openStream();
    }
}
