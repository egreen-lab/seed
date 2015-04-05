package org.egreen.seed.sample.feature;

import org.egreen.seed.kernel.api.config.annotation.Provider;
import org.egreen.seed.sample.feature.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dewmal on 4/3/15.
 */
@Provider(id = 34, feature = UserManagement.class, version = "0.0.0.1")
public class UserManagementImpl implements UserManagement {

    private Map<String, User> userMap = new HashMap<>();

//    @Override
    public void save(User user) {
        user.setUserId(userMap.keySet().size() + "");
        userMap.put(user.getUserId(), user);
    }

//    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }
}
