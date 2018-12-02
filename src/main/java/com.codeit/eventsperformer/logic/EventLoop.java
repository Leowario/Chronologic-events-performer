package com.codeit.eventsperformer.logic;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Timer;

/**
 * @author Vitalii Usatiy
 */
public class EventLoop {

    private EventLoop() {

    }

    public static EventLoop instance() {
        return Singleton.VALUE.value();
    }

      void start(PriorityQueue<Event> eventQueue) {
        Timer timer = new Timer();
        Iterator<Event> iterator = eventQueue.iterator();

        while (iterator.hasNext()) {
            Event event = eventQueue.poll();
            long milliseconds = event.getTimeMillis();
            if (!iterator.hasNext()) {// if current event is last
                timer.schedule(new Action(event.getEventName(), timer, true), milliseconds);
            } else {
                timer.schedule(new Action(event.getEventName()), milliseconds);
            }
        }
    }

    private enum Singleton {
        VALUE;
        private EventLoop value() {
            return new EventLoop();
        }
    }
}
