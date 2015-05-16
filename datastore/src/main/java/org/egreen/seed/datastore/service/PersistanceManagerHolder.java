package org.egreen.seed.datastore.service;

import javax.jdo.PersistenceManagerFactory;

/**
 * Created by dewmal on 5/16/15.
 */

public class PersistanceManagerHolder {
    private final PersistenceManagerFactory managerFactory;

    public PersistanceManagerHolder(PersistenceManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }


    public PersistenceManagerFactory getManagerFactory() {
        return managerFactory;
    }
}
