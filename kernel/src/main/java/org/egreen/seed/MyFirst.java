package org.egreen.seed;

import org.jboss.weld.environment.osgi.api.annotation.Publish;


/**
 * Created by dewmal on 4/18/15.
 */

//@Singleton
public class MyFirst {
//    private static final Log LOG = LogFactory.getLog(MyFirst.class);
    public void hello(String msg) {
        System.out.println("Welcome " + msg);
    }


}
