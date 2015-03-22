package org.egreen.seed.sample;


import org.egreen.seed.api.component.SeedComponent;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 3/21/15.
 */
public class Main extends SeedComponent {

    @Override
    public void beforeStart(BundleContext bundleContext) throws Exception {
        registerFeature(HelloWorldFeature.class);
    }



    @Override
    public void afterStart(BundleContext bundleContext) throws Exception {


    }



}