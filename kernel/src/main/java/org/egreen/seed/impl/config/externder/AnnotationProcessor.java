package org.egreen.seed.impl.config.externder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.egreen.seed.FeatureRegistry;
import org.egreen.seed.kernel.api.config.annotation.Feature;
import org.egreen.seed.kernel.api.config.annotation.Provider;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.BundleTrackerCustomizer;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by dewmal on 4/1/15.
 */
public class AnnotationProcessor implements BundleTrackerCustomizer {

    private static final Log LOGGER = LogFactory.getLog(AnnotationProcessor.class);


    final BundleTracker bundleTracker;

    final BundleContext bundleContext;

    public AnnotationProcessor(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.bundleTracker = new BundleTracker(bundleContext, Bundle.STARTING, this);

    }

    @Override
    public Object addingBundle(Bundle bundle, BundleEvent event) {

        try {


            String seedComponent = bundle.getHeaders().get("SeedId");
            if (seedComponent != null) {
                Enumeration<?> entrs = bundle.findEntries("/", "*.class", true);

                if (entrs == null || !entrs.hasMoreElements()) {
                    return null;
                }

                while (entrs.hasMoreElements()) {
                    URL e = (URL) entrs.nextElement();


                    String file = e.getFile();
                    String path = e.getPath();

                    String c = file.replaceAll("/", ".").replaceAll(".class", "").replaceFirst(".", "");
                    LOGGER.info(file + " - " + path);

                    loadClass(bundle, c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void loadClass(Bundle b, String clazz) {


        try {
            Class<?> loaded = b.loadClass(clazz);

            LOGGER.info(" Class "+loaded);
            boolean annotationPresent = loaded.isAnnotationPresent(Provider.class);
            boolean featureAnnotationPresent = loaded.isAnnotationPresent(Feature.class);
            if (annotationPresent || featureAnnotationPresent) {
                registerFeature(loaded, b, featureAnnotationPresent);
            }


        }catch (Exception e){
            LOGGER.error(e);
        }finally {

        }
    }

    private void registerFeature(Class<?> loaded, Bundle bundle, boolean isFeature) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        ServiceReference<FeatureRegistry> serviceReference = bundle.getBundleContext().getServiceReference(FeatureRegistry.class);
        FeatureRegistry service = bundle.getBundleContext().getService(serviceReference);

        if (!isFeature) {

            Provider provider = loaded.getAnnotation(Provider.class);

            Class<?> feature = provider.feature();

            LOGGER.info(feature);

        }


    }


    @Override
    public void modifiedBundle(Bundle bundle, BundleEvent event, Object object) {
    }

    @Override
    public void removedBundle(Bundle bundle, BundleEvent event, Object object) {
    }

    public void close() {
        bundleTracker.close();
    }

    public void open() {
        bundleTracker.open();
    }

}
