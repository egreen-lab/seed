package org.egreen.seed.sample.feature;

import org.egreen.seed.kernel.api.config.annotation.Feature;
import org.egreen.seed.sample.feature.model.User;

/**
 * Created by dewmal on 4/3/15.
 */
@Feature(name = "user-managment",
        description = "develop by E-Green",
        devID = "dewmal@egreen.io",
        createDate = 20150403)
public interface UserManagement {


    void save(User user);

    User getUser(String userId);


}
