package org.egreen.seed.impl.monitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;
import org.egreen.seed.api.monitor.ServiceMonitor;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by dewmal on 4/24/15.
 */
@Component
@Provides(specifications = {ServiceMonitor.class})
public class ServiceMonitorImpl implements ServiceMonitor {

    private static final Log LOG = LogFactory.getLog(ServiceMonitorImpl.class);

    private final Map<ServiceReference, ServiceEvent> serviceEventMap = new Hashtable<ServiceReference, ServiceEvent>();

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {

        LOG.info(serviceEvent);

        analysing(serviceEvent);
    }


    public void analysing(ServiceEvent serviceEvent) {
        serviceEventMap.put(serviceEvent.getServiceReference(), serviceEvent);
    }

    @Override
    public String status(ServiceReference serviceReference) {
        ServiceEvent serviceEvent = serviceEventMap.get(serviceReference);

        switch (serviceEvent.getType()) {
            case ServiceEvent.MODIFIED:
                return "MODIFIED";
            case ServiceEvent.MODIFIED_ENDMATCH:
                return "MODIFIED_ENDMATCH";
            case ServiceEvent.REGISTERED:
                return "REGISTERED";
            case ServiceEvent.UNREGISTERING:
                return "UNREGISTERING";


        }
        return null;

    }
}
