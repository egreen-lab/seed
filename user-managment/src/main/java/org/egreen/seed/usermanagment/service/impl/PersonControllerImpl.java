package org.egreen.seed.usermanagment.service.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.egreen.seed.datastore.model.LongKey;
import org.egreen.seed.datastore.service.impl.DataServiceManagerImpl;
import org.egreen.seed.usermanagment.model.Person;
import org.egreen.seed.usermanagment.service.PersonController;

/**
 * Created by dewmal on 5/15/15.
 */
@Component(immediate = true)
@Service(value = PersonController.class)
public class PersonControllerImpl extends DataServiceManagerImpl<Person, LongKey> implements PersonController {

    static {
        System.out.println("Working Model");
    }

    public PersonControllerImpl() {
        super(Person.class, LongKey.class);
        System.out.println("TEST TEST");
    }
}
