package org.egreen.seed.api.adaptivity.impl;

import org.egreen.seed.api.adaptivity.FeatureKey;

import java.util.UUID;

/**
 * Created by dewmal on 3/22/15.
 */
public class BasicFeatureKey implements FeatureKey {

    private final String uniqueID;

    public BasicFeatureKey(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String getId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getUniqueKey() {
        return uniqueID;
    }
}
