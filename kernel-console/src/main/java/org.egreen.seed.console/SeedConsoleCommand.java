package org.egreen.seed.console;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.ServiceProperty;
import org.apache.felix.service.command.Descriptor;

/**
 * Created by dewmal on 4/8/15.
 */
@Component(immediate = true)
@Instantiate
@Provides
public class SeedConsoleCommand {
    @ServiceProperty(name = "osgi.command.scope", value = "test")
    String scope;

    @ServiceProperty(name = "osgi.command.function", value = "{}")
    String[] function = new String[] { "test" };

    @Descriptor("test")
    public void test() {
        System.out.println("test!");
    }
}
