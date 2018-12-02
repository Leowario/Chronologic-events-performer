package com.codeit.eventsperformer.logic;

import java.util.PriorityQueue;

import static java.util.Collections.addAll;

/**
 * @author Vitalii Usatyi
 */
class EventsQueueFactory {

    private EventsQueueFactory() {

    }

    static PriorityQueue<Event> getQueue(Event[] events) {
        PriorityQueue<Event> eventQueue = new PriorityQueue<>();
        addAll(eventQueue, events);
        return eventQueue;
    }
}
