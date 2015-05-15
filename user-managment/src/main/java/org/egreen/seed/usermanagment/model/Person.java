package org.egreen.seed.usermanagment.model;

/**
 * Created by dewmal on 5/11/15.
 */

import org.egreen.seed.datastore.model.KeyInterface;
import org.egreen.seed.datastore.model.LongKey;
import org.egreen.seed.datastore.model.ModelInterface;

import javax.jdo.annotations.*;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Person implements ModelInterface {
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

    public Person() {
    }

    public Person(long id, String name, String address, long age) {
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

    @Override
    public KeyInterface getID() {
        return new LongKey(getId());
    }
}
