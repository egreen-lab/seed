package org.egreen.seed.impl.adaptivitiy;

import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.egreen.seed.api.adaptivity.Feature;
import org.egreen.seed.api.adaptivity.FeatureKey;
import org.egreen.seed.api.adaptivity.FeatureService;
import org.egreen.seed.api.adaptivity.Role;
import org.egreen.seed.api.log.Logger;
import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.api.log.Type;
import org.egreen.seed.impl.component.config.model.ComponentConfig;
import org.egreen.seed.impl.component.config.model.FeatureConfig;
import org.osgi.framework.BundleContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dewmal on 3/21/15.
 */
public class FeatureServiceManager implements FeatureService {

    private static Logger logger;

    private final BundleContext bundleContext;

    //Features
    private final Map<String, ComponentConfig> components = new HashMap<String, ComponentConfig>();

    //
    private final GenericKeyedObjectPool<String, ? extends Feature> featurePool;


    public FeatureServiceManager(BundleContext bundleContext) {
        logger = bundleContext.getService(bundleContext.getServiceReference(LoggerService.class)); // Init Logger

        this.bundleContext = bundleContext;
        featurePool = new GenericKeyedObjectPool<String, Feature>(new FeaturePoolFactory(bundleContext));
    }


    @Override
    public void registerFeature(Class<Feature<? extends FeatureKey>> featureClass, String key) {

    }


    @Override
    public <F extends Feature<? extends FeatureKey>> F getFeature(Class<F> feature, String component, Role role) throws Exception {

        String featureClassName = feature.getName();

        ComponentConfig componentConfig = components.get(component);
        logger.log(Type.INFO, componentConfig);
        List<FeatureConfig> featureConfigs = componentConfig.getFeatureConfigs();
        String selectedFeature = null;


        for (FeatureConfig featureConfig : featureConfigs) {

            if (featureClassName.equals(featureConfig.getInterface())) {
                selectedFeature = featureConfig.getClassName();
                break;
            }
        }


        logger.log(Type.INFO, bundleContext.getBundle().getBundleId());




       // Class<?> aClass = bundleContext.getBundle().loadClass(selectedFeature);


        Feature featureObject = featurePool.borrowObject(selectedFeature);
        featureObject.init(bundleContext);
        return (F) featureObject;
    }


    @Override
    public void bind(ComponentConfig configuration) {
        logger.log(Type.INFO, configuration);
        components.put(configuration.getId(), configuration);
    }


}
