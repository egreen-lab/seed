package org.egreen.seed.kernel;

/**
 * Created by dewmal on 3/21/15.
 */
public interface SeedKernelListener {

    /**
     * Trigger On Start
     */
    void onStart(Event event);


    /**
     * Trigger On Stop
     */
    void onStop(Event event);


    /**
     * Trigger On Error
     */
    void onError(Event event);
}
