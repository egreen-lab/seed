package org.egreen.seed.api.adaptivity.impl;

import org.egreen.seed.api.adaptivity.FeatureKey;

import java.util.UUID;

/**
 * Created by dewmal on 3/22/15.
 */
public class BasicFeatureKey implements FeatureKey {

    private final String uniqueID;
    private final String componentId;

    public BasicFeatureKey(String uniqueID, String componentId) {
        this.uniqueID = uniqueID;
        this.componentId = componentId;
    }

    @Override
    public String getId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getComponentId() {
        return componentId;
    }


}
