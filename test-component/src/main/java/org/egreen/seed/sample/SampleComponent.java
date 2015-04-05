package org.egreen.seed.sample;

import org.egreen.seed.kernel.api.config.annotation.Activate;
import org.egreen.seed.kernel.api.config.annotation.Component;
import org.osgi.framework.BundleContext;

/**
 * Created by dewmal on 4/1/15.
 */
@Component(immediat = true, properties = {
        "service.component.demo.property=true",
        "service.component.demo.name=Seed Sample Component",
        "osgi.rocks.property=Yes"
})
public class SampleComponent {

    @Activate
    public void init(BundleContext context) {
        System.out.println("Wroking");
    }
}
