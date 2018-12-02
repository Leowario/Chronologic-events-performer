package com.codeit.eventsperformer.logic;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.PriorityQueue;

/**
 * @author Vitalii Usatyi
 */
public class Application {

    private Application() {

    }

    public static Application instance() {
        return Singleton.VALUE.value();
    }

    public void run() {
        try {
            long milsStart = System.currentTimeMillis();
            Event[] events = new EventFactory().getEvents();
            PriorityQueue<Event> eventsQueue = EventsQueueFactory.getQueue(events);
            EventLoop.instance().start(eventsQueue);
        } catch (URISyntaxException | IOException | ParseException e) {
            System.out.println("Parse from JSON Exception");
            e.printStackTrace();
        }
    }

    private enum Singleton {
        VALUE;

        private Application value() {
            return new Application();
        }
    }
}
