package org.egreen.seed.transport.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.util.tracker.ServiceTracker;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Logger;

/**
 * Created by dewmal on 5/6/15.
 */
public class SeedHttpWSTransporterActivator implements BundleActivator {

    private BundleContext bc;
    private ServiceTracker tracker;
    private HttpService httpService = null;
    private static final Log logger = LogFactory.getLog(SeedHttpWSTransporterActivator.class);

    @Override
    public synchronized void start(BundleContext bundleContext) throws Exception {
        this.bc = bundleContext;

        logger.info("STARTING HTTP SERVICE BUNDLE");

        this.tracker = new ServiceTracker(this.bc, HttpService.class.getName(), null) {

            @Override
            public Object addingService(ServiceReference serviceRef) {
                httpService = (HttpService) super.addingService(serviceRef);
                registerServlets();
                return httpService;
            }

            @Override
            public void removedService(ServiceReference ref, Object service) {
                if (httpService == service) {
                    unregisterServlets();
                    httpService = null;
                }
                super.removedService(ref, service);
            }
        };

        this.tracker.open();

        registerServlets();

        logger.info("HTTP SERVICE BUNDLE STARTED");
    }

    @Override
    public synchronized void stop(BundleContext bundleContext) throws Exception {
        unregisterServlets();
        this.tracker.close();
    }

    private void registerServlets() {
        try {
            rawRegisterServlets();
        } catch (InterruptedException | NamespaceException | ServletException ie) {
            throw new RuntimeException(ie);
        }
    }

    private void rawRegisterServlets() throws ServletException, NamespaceException, InterruptedException {
        logger.info("JERSEY BUNDLE: REGISTERING SERVLETS");
        logger.info("JERSEY BUNDLE: HTTP SERVICE = " + httpService.toString());

        // TODO - temporary workaround
        // This is a workaround related to issue JERSEY-2093; grizzly (1.9.5) needs to have the correct context
        // classloader set
        ClassLoader myClassLoader = getClass().getClassLoader();
        ClassLoader originalContextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(myClassLoader);
            httpService.registerServlet("/jersey-http-service", new ServletContainer(), getJerseyServletParams(), null);
        } finally {
            Thread.currentThread().setContextClassLoader(originalContextClassLoader);
        }
        // END of workaround - after grizzly updated to the recent version, only the inner call from try block will remain:
        // httpService.registerServlet("/jersey-http-service", new ServletContainer(), getJerseyServletParams(), null);

        sendAdminEvent();
        logger.info("JERSEY BUNDLE: SERVLETS REGISTERED");
    }

    private void sendAdminEvent() {
//        ServiceReference eaRef = bc.getServiceReference(EventAdmin.class.getName());
//        if (eaRef != null) {
//            EventAdmin ea = (EventAdmin) bc.getService(eaRef);
//            ea.sendEvent(new Event("jersey/test/DEPLOYED", new HashMap<String, String>() {
//                {
//                    put("context-path", "/");
//                }
//            }));
//            bc.ungetService(eaRef);
//        }
    }

    private void unregisterServlets() {
        if (this.httpService != null) {
            logger.info("JERSEY BUNDLE: UNREGISTERING SERVLETS");
            httpService.unregister("/jersey-http-service");
            logger.info("JERSEY BUNDLE: SERVLETS UNREGISTERED");
        }
    }

    @SuppressWarnings("UseOfObsoleteCollectionType")
    private Dictionary<String, String> getJerseyServletParams() {
        Dictionary<String, String> jerseyServletParams = new Hashtable<>();
        jerseyServletParams.put("javax.ws.rs.Application", JerseyApplication.class.getName());
        return jerseyServletParams;
    }
}