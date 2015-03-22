package org.egreen.seed.api.adaptivity;

import org.osgi.framework.BundleContext;

import java.util.List;

/**
 * Can be work AS Async TASK Or Sync Task
 * <p/>
 * Any Other Features Can be use
 * <p/>
 * <p/>
 * <p/>
 * Created by dewmal on 3/21/15.
 */
public interface Feature<K extends FeatureKey> {


    /**
     * Init after Call Default Constructor
     *
     * @param context
     */
    void init(BundleContext context);


    /**
     * @param spectator
     */
    void registerSpectator(Spectator spectator);

    /**
     * Get Feature ID
     *
     * @return
     */
    K getKey();


    /**
     * Get Feature Name
     *
     * @return
     */
    String getName();


    /**
     * Get Feature Version
     *
     * @return
     */
    String getVersion();


    /**
     * Features Can Define Roles
     * <p/>
     * Features has many faces by covering Roles
     *
     * @return
     */
    List<Role> getRoleList();


    /**
     * Define Service Access Role
     * <p/>
     * Using this Role Base Access
     * All methods provide better Security Coverage for Features
     *
     * @param accessRole
     */
    void setAccessRole(Role accessRole);


    /**
     * Access Platform Services
     *
     * @return
     */
    BundleContext getBundleContext();


    /**
     * Set Bundle Context
     *
     * @param bundleContext
     */
    void setBundleContext(BundleContext bundleContext);

}
