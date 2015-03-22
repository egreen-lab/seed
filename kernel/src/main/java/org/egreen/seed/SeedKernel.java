package org.egreen.seed;

import org.egreen.seed.api.log.Type;
import org.egreen.seed.impl.adaptivitiy.FeatureServiceManager;
import org.egreen.seed.api.Kernel;
import org.egreen.seed.api.adaptivity.FeatureService;
import org.egreen.seed.api.kernel.Event;
import org.egreen.seed.api.kernel.SeedKernelListener;
import org.egreen.seed.api.log.LoggerService;
import org.egreen.seed.impl.utils.Utils;
import org.osgi.framework.BundleContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Handle All Seed Activities thorough this Seed kernel
 * <p/>
 * Created by dewmal on 3/21/15.
 */
public class SeedKernel implements Kernel {

    private final List<SeedKernelListener> seedKernelListeners = new ArrayList<SeedKernelListener>(); //They will Triggers On Seed Kernel Events
    private LoggerService loggerService;
    private BundleContext bundleContext;
    private FeatureService featureService;


    /**
     * Initializing Seed Kernel Before Start
     *
     * @param bundleContext
     */
    public void init(BundleContext bundleContext) {
        this.bundleContext = bundleContext;

        loggerService = Utils.getDefaultLogger();
        bundleContext.registerService(LoggerService.class, loggerService, null);// Register Logger With OSGI Platform



        featureService=new FeatureServiceManager(bundleContext);
        loggerService.log(Type.INFO,featureService);
        bundleContext.registerService(FeatureService.class,featureService,null);

    }


    /**
     * Starting seed kernel
     */
    public void start() {
        triggerOnEvent(new Event(this, Event.EventType.START));






    }


    /**
     * Stopping Seed Kernel
     */
    public void stop() {
        triggerOnEvent(new Event(this, Event.EventType.START));
    }


    /**
     * Register Seed Kernel Listener
     *
     * @param seedKernelListener
     */
    public void registerSeedKernelListener(SeedKernelListener seedKernelListener) {
        this.seedKernelListeners.add(seedKernelListener);
    }


    /**
     * Un Register Seed Kernel Listener
     *
     * @param seedKernelListener
     */
    public void unRegisterSeedKernelListener(SeedKernelListener seedKernelListener) {
        this.seedKernelListeners.remove(seedKernelListener);
    }


    /**
     * Process on Kernel Events
     *
     * @param event
     */
    private void triggerOnEvent(Event event) {
        for (SeedKernelListener seedKernelListener : seedKernelListeners) {
            switch (event.getType()) {
                case START: {
                    seedKernelListener.onStart(event);// Trigger On Server Start
                    break;
                }
                case STOP: {
                    seedKernelListener.onStop(event);// Trigger On Server Stop
                    break;
                }
                case ERROR: {
                    seedKernelListener.onError(event);// Trigger On Server Error
                    break;
                }
            }
        }


    }


}
