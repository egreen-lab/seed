package org.egreen.seed.platform;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

/**
 * Created by dewmal on 5/6/15.
 */
public class SeedFramwork {
    public static void main(String[] args) throws BundleException, MalformedURLException {

        long startTime = Calendar.getInstance().getTimeInMillis();


        // Load a framework factory
        FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();
        // Create a framework
        Map<String, String> config = new HashMap<String, String>();

        // TODO: add some config properties
        config.put("felix.auto.deploy.dir","./plugins");
        config.put("felix.auto.deploy.action","start");

        config.put("felix.fileinstall.dir","./plugins");
        config.put("org.osgi.service.http.port", "8090");


        Framework framework = frameworkFactory.newFramework(config);
        // Start the framework
        framework.start();




        System.out.println(Arrays.toString(framework.getBundleContext().getBundles()));

        BundleContext context = framework.getBundleContext();
        List<Bundle> installedBundles = new LinkedList<Bundle>();



        File file=new File("./library");
        File[] files = file.listFiles();
        for (File bundleFile : files) {
            installedBundles.add(context.installBundle("file:./library/"+bundleFile.getName()));
        }


        for (Bundle bundle : installedBundles) {
            bundle.start();
        }
        System.out.println(Calendar.getInstance().getTimeInMillis() - startTime);
    }

}
