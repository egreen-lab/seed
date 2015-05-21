package org.egreen.seed.platform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.egreen.seed.platform.utills.FileUtils;
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

    private static final Log LOG = LogFactory.getLog(SeedFramwork.class);


    public static void main(String[] args) throws BundleException, MalformedURLException {


        long startTime = Calendar.getInstance().getTimeInMillis();

        makeRuntimeConfig();

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


    /**
     * Create Runtime Configurations
     */
    private static void makeRuntimeConfig() {

        FileUtils.deleteDirectory(new File("felix-cache"));

        LOG.info("Cleaned Felix Cache");

    }

}
