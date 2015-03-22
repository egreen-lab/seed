package org.egreen.seed.impl.component.config;

import org.egreen.seed.impl.component.SeedComponentActivator;
import org.egreen.seed.impl.component.config.model.ComponentConfig;

import java.io.IOException;

/**
 * Created by dewmal on 3/22/15.
 */
public interface ComponentResolver {


    /**
     * Resolve Component Configuration
     *
     * @return
     */
    ComponentConfig getComponentConfiguration(SeedComponentActivator seedComponentActivator) throws Exception;
}
