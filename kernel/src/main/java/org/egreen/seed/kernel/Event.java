package org.egreen.seed.kernel;

import org.egreen.seed.SeedKernel;

/**
 * Created by dewmal on 3/21/15.
 */
public class Event {

    private final SeedKernel source;
    private final EventType type;


    public Event(SeedKernel source, EventType type) {
        this.source = source;
        this.type = type;
    }

    public SeedKernel getSource() {
        return source;
    }


    public EventType getType() {
        return type;
    }

    /**
     * Event Has Type
     */
    public enum EventType {

        START("start", 1),
        STOP("stop", 0),
        ERROR("error", -1);


        private final String type;
        private final int code;

        EventType(String type, int code) {
            this.type = type;
            this.code = code;
        }

        public String getType() {
            return type;
        }
    }
}
