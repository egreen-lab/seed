package org.egreen.seed.usermanagment.service;


import org.apache.felix.scr.annotations.Service;
import org.egreen.seed.datastore.model.LongKey;
import org.egreen.seed.datastore.service.DataServiceManager;
import org.egreen.seed.datastore.service.impl.DataServiceManagerImpl;
import org.egreen.seed.usermanagment.model.Person;
import org.osgi.service.component.annotations.Component;

/**
 * Created by dewmal on 5/12/15.
 */


public interface PersonController extends DataServiceManager<Person, LongKey> {


}
