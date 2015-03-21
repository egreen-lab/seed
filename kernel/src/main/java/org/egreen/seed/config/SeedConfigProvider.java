package org.egreen.seed.config;

import org.egreen.seed.config.model.SeedConfiguration;

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
