package org.egreen.seed.platform;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import java.io.File;
import java.util.*;

/**
 * Created by dewmal on 4/26/15.
 */
public class SeedPlatformBootstrapper {

    private static final String base="platform/";
    private static String[] jars = new String[]{};
    private static String[] libs = new String[]{};

    private BundleContext context;

    private SeedPlatformBootstrapper() throws BundleException {

        FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();

        Map<String, String> config = new HashMap<String, String>();
//        config.put("osgi.console", "");
//        config.put("osgi.clean", "true");
//        config.put("osgi.noShutdown", "true");
//        config.put("eclipse.ignoreApp", "true");
//        config.put("osgi.bundles.defaultStartLevel", "4");
//        config.put("osgi.configuration.area", "./configuration");

        // config.put("osgi.debug", "configuration/debug.options");
        // config.put("osgi.console", "localhost:2223");
        // config.put("osgi.console.ssh", "localhost:2222");
        // config.put("osgi.console.ssh.useDefaultSecureStorage", "true");
        // config.put("osgi.console.enable.builtin", "false");

        // automated bundles deployment
//        config.put("felix.fileinstall.dir", "./dropins");
        config.put("felix.fileinstall.noInitialDelay", "true");
        config.put("felix.fileinstall.start.level", "4");

        //@formatter:off
        // System.setProperty("ssh.server.keystore", "configuration/hostkey.ser");
        // System.setProperty("org.eclipse.equinox.console.jaas.file", "configuration/store");
        // System.setProperty("java.security.auth.login.config", "configuration/org.eclipse.equinox.console.authentication.config");
        //@formatter:on



        Framework framework = frameworkFactory.newFramework(config);

        framework.init();
        framework.start();


    }

    public static void main(String[] args) {
        try {
            new SeedPlatformBootstrapper();
        } catch (BundleException e) {
            e.printStackTrace();
        }
    }

    private String[] getJARs() {
        if (jars == null||jars.length==0) {
            List<String> jarsList = new ArrayList<String>();
            File pluginsDir = new File(base+"/plugins");
            System.out.println( Arrays.toString(pluginsDir.list()));
            if (pluginsDir.list() != null) {
                for (String jar : pluginsDir.list()) {
                    jarsList.add(jar);
                }
                jars = jarsList.toArray(new String[jarsList.size()]);
            }
        }
        return jars;
    }

    private String[] getLibs() {
        if (libs == null||libs.length==0) {
            List<String> jarsList = new ArrayList<String>();
            File pluginsDir = new File(base+"libs");
            if (pluginsDir.list() != null) {
                for (String jar : pluginsDir.list()) {
                    jarsList.add(jar);
                }
                libs = jarsList.toArray(new String[jarsList.size()]);
            }
        }
        return libs;
    }

    protected Bundle start(String name) {
        Bundle bundle = install(name);
        if (bundle != null) {
            try {
                bundle.start();
            } catch (BundleException e) {
                e.printStackTrace();
            }
        }
        return bundle;
    }

    protected Bundle install(String name) {
        String found = null;
        for (String jar : getJARs()) {
            if (jar.startsWith(name + "_") || jar.startsWith(name + "-")) {
                found = String.format("file:"+base+"plugins/%s", jar);
                break;
            }
        }
        for (String jar : getLibs()) {
            if (jar.startsWith(name + "_") || jar.startsWith(name + "-")) {
                found = String.format("file:"+base+"libs/%s", jar);
                break;
            }
        }
        if (found == null) {
            throw new RuntimeException(String.format("JAR for %s not found", name));
        }
        try {
            return context.installBundle(found);
        } catch (BundleException e) {
            e.printStackTrace();
        }
        return null;
    }
}
