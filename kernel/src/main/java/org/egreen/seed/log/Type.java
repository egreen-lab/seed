package org.egreen.seed.log;

/**
 * Created by dewmal on 3/21/15.
 */
public enum Type {

    INFO(0),

    WARN(1),

    ERROR(2),

    FATAL(4);

    private final int level;

    Type(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
