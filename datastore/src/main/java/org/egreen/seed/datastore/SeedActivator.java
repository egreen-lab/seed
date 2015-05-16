package org.egreen.seed.datastore;

import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;
import org.datanucleus.util.NucleusLogger;
import org.egreen.seed.datastore.model.User;
import org.egreen.seed.datastore.service.PersistanceManagerHolder;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by dewmal on 5/6/15.
 */
public class SeedActivator implements BundleActivator {
    private int MAX_NUM_ITERATIONS = 10;

    BundleContext bundleContext = null;
    PersistenceManagerFactory pmf = null;

    public void start(BundleContext bundleContext) {
        System.out.println("JDO:OSGi.start Creating PMF");
        this.bundleContext = bundleContext;

        ClassLoader cl = getClassLoader();

        // Create PMF using properties. OSGi seems to have problems finding persistence.xml
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("datanucleus.primaryClassLoader", cl);

        props.put("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        props.put("datanucleus.plugin.pluginRegistryClassName", "org.datanucleus.plugin.OSGiPluginRegistry");
        props.put("javax.jdo.option.ConnectionURL", "jdbc:mysql://localhost/mytestseed");
        props.put("javax.jdo.option.ConnectionDriverName", "com.mysql.jdbc.Driver");
        props.put("javax.jdo.option.ConnectionUserName", "root");
        props.put("javax.jdo.option.ConnectionPassword", "dew");
        props.put("datanucleus.autoCreateSchema", "true");
        props.put("datanucleus.autoCreateColumns", "true");

        pmf = JDOHelper.getPersistenceManagerFactory(props, JDOPersistenceManagerFactory.class.getClassLoader());
//        PersistenceManager pm = pmf.getPersistenceManager();
        System.out.println("JDO:OSGi.start - PM created");


        bundleContext.registerService(PersistanceManagerHolder.class.getName(), new PersistanceManagerHolder(pmf), null);



//        Transaction tx = pm.currentTransaction();
//        try
//        {
//            tx.begin();
//            User p;
//            for (int i=0; i<MAX_NUM_ITERATIONS; i++)
//            {
//                p = new User(i, "Name"+i, "Address"+i, 20+i);
//                pm.makeTransient(p);
//                pm.makePersistent(p);
//            }
//            tx.commit();
//            System.out.println("JDO:OSGi.start - " + MAX_NUM_ITERATIONS + " Person objects have been persisted");
//        }
//        catch (Exception e)
//        {
//            NucleusLogger.GENERAL.info(">> Exception in query", e);
//            e.printStackTrace();
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//            pm.close();
//            System.out.println("JDO:OSGi.start - PM closed");
//        }
//
        System.out.println("JDO:OSGi.start - completed");
    }

    private ClassLoader getClassLoader() {
        ClassLoader classloader = null;
        Bundle[] bundles = bundleContext.getBundles();

        for (int x = 0; x < bundles.length; x++) {
            if (bundles[x].getSymbolicName().startsWith("org.datanucleus.api.jdo")) {
                try {
                    classloader = bundles[x].loadClass("org.datanucleus.api.jdo.JDOPersistenceManagerFactory").getClassLoader();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        return classloader;
    }

    public void stop(BundleContext bundleContext) {
        System.out.println("JDO:OSGi.stop Closing PMF");
        if (pmf != null && !pmf.isClosed()) {
            pmf.close();
        }
    }


}
