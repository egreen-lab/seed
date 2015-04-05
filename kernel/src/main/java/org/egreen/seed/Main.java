package org.egreen.seed;

import org.egreen.seed.impl.config.externder.AnnotationProcessor;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 3/21/15.
 */
public class Main implements BundleActivator {

    public static final boolean DEBUG = true;

    private AnnotationProcessor annotationProcessor;


    public void initMain(BundleContext bundleContext) {

        bundleContext.registerService(FeatureRegistry.class, new FeatureRegistry(), null);


        annotationProcessor = new AnnotationProcessor(bundleContext);
        annotationProcessor.open();
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        initMain(bundleContext); // Init this
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        annotationProcessor.close();
    }





}
