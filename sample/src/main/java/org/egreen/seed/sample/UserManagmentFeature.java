package org.egreen.seed.sample;

import org.egreen.seed.sample.model.User;

import java.util.List;

/**
 * Created by dewmal on 4/5/15.
 */
public interface UserManagmentFeature {

    User getUser(String username);

    List<User> getAll();

    long saveUser(User user);

}
