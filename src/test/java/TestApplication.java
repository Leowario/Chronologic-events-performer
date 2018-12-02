import com.codeit.eventsperformer.logic.Event;
import com.codeit.eventsperformer.logic.EventLoop;
import com.codeit.eventsperformer.logic.EventParser;
import com.codeit.eventsperformer.logic.EventsQueueFactory;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

@DisplayName("Application should:")
class TestApplication {

    @Test
    @DisplayName("parse from JSON to array of Events")
    void parseFromJsonTest() throws ParseException, IOException, URISyntaxException {

        Event[] events = getEvents();
        Assertions.assertEquals("01:15", events[events.length - 1].getTime());
    }

    @Test
    @DisplayName("run event loop")
    void eventLoopTest() throws ParseException, IOException, URISyntaxException {
        EventLoop.instance().start(EventsQueueFactory.getQueue(getEvents()));
    }

    private Event[] getEvents() throws URISyntaxException, IOException, ParseException {
        EventParser eventParser = new EventParser();
        return eventParser.parse();
    }

}
