package org.egreen.seed.api.adaptivity.impl;

import org.egreen.seed.api.adaptivity.Feature;
import org.egreen.seed.api.adaptivity.FeatureKey;
import org.egreen.seed.api.adaptivity.Role;
import org.egreen.seed.api.adaptivity.Spectator;
import org.osgi.framework.BundleContext;

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

    // Access Bundle Context
    private BundleContext context;

    public BasicFeature(T basicKey) {
        this.basicKey = basicKey;
    }


    @Override
    public void setBundleContext(BundleContext bundleContext) {
        this.context = bundleContext;
    }

    @Override
    public BundleContext getBundleContext() {
        return context;
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

    /**
     * GET Services
     *
     * @param var1
     * @param <S>
     * @return
     */
    protected <S> S getService(Class<S> var1) {
        return getBundleContext().getService(getBundleContext().getServiceReference(var1));
    }

    @Override
    public final void init(BundleContext context) {
        this.context = context;
        onCreate(context);
    }


    public abstract void onCreate(BundleContext context);
}
