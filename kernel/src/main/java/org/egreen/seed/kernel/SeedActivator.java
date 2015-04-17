package org.egreen.seed.kernel;

import com.sun.enterprise.glassfish.bootstrap.osgi.EmbeddedOSGiGlassFishImpl;
import com.sun.enterprise.glassfish.bootstrap.osgi.EmbeddedOSGiGlassFishRuntime;
import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import java.io.File;
import java.util.*;

/**
 * Created by dewmal on 4/8/15.
 */

public class SeedActivator {


    private static String APP_NAME = "seed-test";

    static class HostActivator
            implements BundleActivator {

        private BundleContext context = null;

        @Override
        public void start(BundleContext bc) {
            context = bc;
            System.out.println("working");
        }

        @Override
        public void stop(BundleContext bc) {
            context = null;
        }

        public BundleContext getContext() {
            return context;
        }

    }

    public static void main(String[] args)
            throws Exception {


        File file = new File("/home/dewmal/.seed/" + APP_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }


        Map<String, Object> map = new HashMap<String, Object>();

        map.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA,
                "some.module.i.dont.know; version=1.0.0");
        map.put(Constants.FRAMEWORK_STORAGE, file.getAbsolutePath()+"/cache");

        HostActivator activator = new HostActivator();

        List<Object> list = new LinkedList<Object>();
        list.add(activator);
        map.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, list);
        map.put("com.sun.aas.installRoot", file.getAbsolutePath());
        map.put("com.sun.aas.instanceRoot", file.getAbsolutePath()+"/doamin");
        Felix f = new Felix(map);




        System.out.println("starting OSGI...");
        f.start();




        Bundle[] bundles = f.getBundleContext().getBundles();
        System.out.println(Arrays.toString(bundles));
        ;


//        f.getBundleContext().installBundle("file:////home/dewmal/software/lab/seed/build/osgi/bundle/org.osgi.core-4.3.1.jar");


        GlassFishProperties glassfishProperties = new GlassFishProperties();
        glassfishProperties.setPort("http-listener", 9090);
        glassfishProperties.setPort("https-listener", 8181);
        GlassFish glassfish = EmbeddedOSGiGlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
        EmbeddedOSGiGlassFishImpl embeddedOSGiGlassFish = new EmbeddedOSGiGlassFishImpl(glassfish, f.getBundleContext());


        embeddedOSGiGlassFish.start();
//
    }

//    //
}
