package org.egreen.seed;

import org.egreen.seed.api.kernel.Event;
import org.egreen.seed.api.kernel.SeedKernelListener;
import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.api.log.Type;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by dewmal on 3/21/15.
 */
public class Main implements BundleActivator, SeedKernelListener {


    private SeedKernel seedKernel;// Define Seed Kernel


    private LoggerService loggerService;

    public void initMain(BundleContext bundleContext) {
        // Init Kernel
        seedKernel = new SeedKernel();

        // Register Event Processors
        seedKernel.registerSeedKernelListener(this);

        // Init Seed Kernel
        seedKernel.init(bundleContext);

        //Bind Logger Service
        ServiceReference<LoggerService> LoggerServiceReference = bundleContext.getServiceReference(LoggerService.class);
        loggerService = bundleContext.getService(LoggerServiceReference);
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        initMain(bundleContext); // Init this
        seedKernel.start(); // Start Method Call



    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        seedKernel.stop(); // End Method Call
    }


    /**
     * Default Seed Kernel Listener
     *
     * @param event
     */
    @Override
    public void onStart(Event event) {
        loggerService.log(Type.INFO, event.getSource() + "");
    }

    @Override
    public void onStop(Event event) {
        loggerService.log(Type.INFO, event.getSource() + "");
    }

    @Override
    public void onError(Event event) {
        loggerService.log(Type.ERROR, event.getSource() + "");
    }


}
