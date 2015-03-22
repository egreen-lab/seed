package org.egreen.seed.api.kernel;

import org.egreen.seed.api.Kernel;

/**
 * Created by dewmal on 3/21/15.
 */
public class Event {

    private final Kernel source;
    private final EventType type;


    public Event(Kernel source, EventType type) {
        this.source = source;
        this.type = type;
    }

    public Kernel getSource() {
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
