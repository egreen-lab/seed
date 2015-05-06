package org.egreen.seed.api.monitor;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

/**
 * Created by dewmal on 4/24/15.
 */
public interface ServiceMonitor extends ServiceListener {

   void analysing(ServiceEvent serviceEvent);


    String status(ServiceReference serviceReference);
}
