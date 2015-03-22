package org.egreen.seed.impl.config;

import org.egreen.seed.impl.config.model.SeedConfiguration;

/**
 * Created by dewmal on 3/21/15.
 */
public interface SeedConfigProvider {
    /**
     * Returns a populated SeedConfiguration instance
     *
     * @return a instance of the SeedConfiguration
     */
    public SeedConfiguration getSeedConfiguration();
}
