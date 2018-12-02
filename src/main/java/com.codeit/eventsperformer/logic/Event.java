package com.codeit.eventsperformer.logic;

import com.google.common.annotations.VisibleForTesting;

import java.util.Objects;

/**
 * @author Vitalii Usatyi
 */
public class Event implements Comparable<Event> {
    private String eventName;
    private String time;
    private long timeMillis;

    private Event() {
    }

    public Event setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Event setTime(String time) {
        this.time = time;
        return this;
    }

    void setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    String getEventName() {
        return eventName;
    }
@VisibleForTesting
    public String getTime() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return timeMillis == event.timeMillis &&
                Objects.equals(eventName, event.eventName) &&
                Objects.equals(time, event.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eventName, time, timeMillis);
    }

    @Override
    public int compareTo(Event e) {
        return Long.compare(timeMillis, e.timeMillis);
    }
}
