package org.egreen.seed.sample.two;

import org.egreen.seed.kernel.api.config.annotation.Activate;
import org.egreen.seed.kernel.api.config.annotation.Component;
import org.egreen.seed.kernel.api.config.annotation.InjectFeature;
import org.egreen.seed.sample.feature.UserManagement;
import org.egreen.seed.sample.feature.model.User;

/**
 * Created by dewmal on 4/3/15.
 */
@Component
public class Main {

    @InjectFeature(provider = 34)
    private UserManagement userManagement;


    @Activate
    public void init() {
        User user = new User();
        user.setUserId("AAA");
        user.setUserName("Dewmal");
        user.setPassword("123");
        userManagement.save(user);
        System.out.println(userManagement.getUser("AAA"));
    }
}
