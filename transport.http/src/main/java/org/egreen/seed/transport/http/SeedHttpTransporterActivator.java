package org.egreen.seed.transport.http;

import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dewmal on 5/6/15.
 */
public class SeedHttpTransporterActivator implements BundleActivator {

    private static final String HELLOWORLDAPP = "/helloworld";
    private static final String CONTEXT_PATH = "/remoteagent";
    private static int SERVER_PORT = 9000;
    private static HttpServer server;

    @Requires
    private HttpService http;


    @Validate
    public void start() {

        runServer();
    }

    @Invalidate
    public void stop() {
        stopServer();
    }

    private static void runServer() {
        System.out.println("Starting Server");
        server = HttpServer.createSimpleServer(CONTEXT_PATH, SERVER_PORT);


        server.getServerConfiguration().addHttpHandler(
                new HttpHandler() {
                    public void service(Request request, Response response) throws Exception {
                        final SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
                        final String date = format.format(new Date(System.currentTimeMillis()));
                        response.setContentType("text/plain");
                        response.setContentLength(date.length());
                        response.getWriter().write(date);
                    }
                },
                "/servertime");

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void stopServer() {

        System.out.println("Stopping Server");
        if (server != null) {
            server.shutdownNow();
        }
    }


    @Override
    public void start(BundleContext bundleContext) throws Exception {
        String httpServerPort = bundleContext.getProperty("org.osgi.service.http.port");
        try {
            SERVER_PORT = Integer.parseInt(httpServerPort);
        } catch (Exception e) {
            throw new IllegalArgumentException("Http Port Number Should be Integer");
        }

        start();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        stop();
    }
}