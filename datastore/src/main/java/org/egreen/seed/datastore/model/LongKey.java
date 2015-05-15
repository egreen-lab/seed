package org.egreen.seed.datastore.model;

/**
 * Created by dewmal on 5/12/15.
 */
public class LongKey  implements KeyInterface<Long> {


    private final Long value;

    public LongKey(Long value) {
        this.value = value;
    }

    @Override
    public Long getValue() {
        return value;
    }
}
