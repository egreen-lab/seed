package org.egreen.seed.api.adaptivity.impl;

import org.egreen.seed.api.adaptivity.Feature;
import org.egreen.seed.api.adaptivity.FeatureKey;
import org.egreen.seed.api.adaptivity.Role;
import org.egreen.seed.api.adaptivity.Spectator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dewmal on 3/22/15.
 */
public abstract class BasicFeature<T extends FeatureKey> implements Feature<T> {

    private final List<Spectator> spectators = new ArrayList<Spectator>();
    private final T basicKey;
    private final List<Role> roles = new ArrayList<Role>();

    // Which Role Using this feature
    protected Role accessRole;

    public BasicFeature(T basicKey) {
        this.basicKey = basicKey;
    }

    @Override
    public void registerSpectator(Spectator spectator) {
        spectators.add(spectator);
    }

    @Override
    public T getKey() {
        return basicKey;
    }


    @Override
    public List<Role> getRoleList() {
        return roles;
    }

    @Override
    public void setAccessRole(Role accessRole) {
        this.accessRole = accessRole;
    }
}
