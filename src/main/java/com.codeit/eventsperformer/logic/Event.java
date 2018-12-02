package com.codeit.eventsperformer.logic;

/**
 * @author Vitalii Usatyi
 */
public class Event {

    private String eventName;
    private String time;
    private long timeMillis;

    private Event() {
    }

    public Event(String eventName, String time) {
        this.eventName = eventName;
        this.time = time;
    }

    Event setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
        return this;
    }


    String getEventName() {
        return eventName;
    }

    String getTime() {
        return time;
    }

    long getTimeMillis() {
        return timeMillis;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


}
