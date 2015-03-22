package org.egreen.seed.api.adaptivity;

/**
 * Created by dewmal on 3/21/15.
 */
public interface Role {

    String getName();

    String getKey();


    public enum MainRole implements Role {

        ADMIN("admin", "admin"),
        MANAGER("manager", "manager");

        private final String name;
        private final String key;

        MainRole(String name, String key) {
            this.name = name;
            this.key = key;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getKey() {
            return null;
        }
    }
}
