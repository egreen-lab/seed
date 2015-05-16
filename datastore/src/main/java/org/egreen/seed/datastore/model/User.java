package org.egreen.seed.datastore.model;

import javax.jdo.annotations.*;

/**
 * Created by dewmal on 5/16/15.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {

    private static final long serialVersionUID = -6683657819521508894L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private long id;
    @Persistent
    private String name;
    @Persistent
    private String address;
    @Persistent
    private long age;
    @Persistent
    private String firstName;

    public User() {
    }

    public User(long id, String name, String address, long age) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
