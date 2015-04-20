package org.egreen.seed;

import org.jboss.weld.environment.osgi.api.annotation.Publish;
import org.jboss.weld.environment.osgi.api.events.BundleContainerEvents;
import org.osgi.framework.BundleContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.CDI;

/**
 * Created by dewmal on 3/21/15.
 */
@Publish
@ApplicationScoped
public class App {


//    private static final Log LOG = LogFactory.getLog(Main.class);


//    @Inject
//    MyFirst helloWorld;

    public void onStartup(@Observes BundleContainerEvents.BundleContainerInitialized event, BundleContext ctx) {

        System.out.println("working");
//        LOG.info("AAAA");

       // helloWorld.hello("Welcome");
    }

    public void onShutdown(@Observes BundleContainerEvents.BundleContainerShutdown event, BundleContext ctx) {
        //helloWorld.hello("Bye");
    }
}
