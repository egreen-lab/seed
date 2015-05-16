package org.egreen.seed.usermanagment;

import org.apache.felix.ipojo.annotations.*;
import org.egreen.seed.datastore.model.LongKey;
import org.egreen.seed.usermanagment.model.Person;
import org.egreen.seed.usermanagment.service.PersonController;


/**
 * Created by dewmal on 5/6/15.
 */
@Component
@Instantiate
public class SeedActivator {

    @Requires
    private PersonController personController;


    @Validate
    public void start() {

        System.out.println("Working" + personController.getPm());


        Person person = new Person( "q23423", "23432", 56);
        LongKey longKey = personController.create(person);

        System.out.println("MY MY" + longKey.getValue());

    }

    @Invalidate
    public void stop() throws Exception {

    }

}
