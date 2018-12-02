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
            System.out.println("Start time: "+System.currentTimeMillis());
            Event[] events = new EventParser().parse();
            PriorityQueue<Event> eventsQueue = EventsQueueFactory.getQueue(events);
            EventLoop.instance().start(eventsQueue);
        } catch (URISyntaxException | IOException | ParseException e) {
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
