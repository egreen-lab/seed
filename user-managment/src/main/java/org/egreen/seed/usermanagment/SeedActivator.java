package org.egreen.seed.usermanagment;

import org.egreen.seed.datastore.service.DataServiceManager;
import org.egreen.seed.datastore.service.impl.DataServiceManagerImpl;
import org.egreen.seed.usermanagment.model.Person;
import org.egreen.seed.usermanagment.service.PersonController;
import org.egreen.seed.usermanagment.service.impl.PersonControllerImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/**
 * Created by dewmal on 5/6/15.
 */
public class SeedActivator implements BundleActivator {

    //    @Reference
    private PersonController personController;


    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("WOOO");

        System.out.println(DataServiceManager.class.getCanonicalName());
        System.out.println(DataServiceManagerImpl.class.getCanonicalName());
        personController = (PersonController) bundleContext.
                getService(bundleContext.
                        getServiceReference(PersonControllerImpl.class.getCanonicalName()));

        System.out.println("Working odd");

        Person person = new Person(21, "q23423", "23432", 56);
        personController.create(person);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }

}
