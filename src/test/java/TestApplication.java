import com.codeit.eventsperformer.logic.Event;
import com.codeit.eventsperformer.logic.EventParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

@DisplayName("Application should:")
class TestApplication {

    @Test
    @DisplayName("parse from JSON")
    void parseFromJson() throws ParseException, IOException, URISyntaxException {

        EventParser eventParser = new EventParser();
        Event[] events = eventParser.parse();
        Assertions.assertEquals("01:15", events[events.length - 1].getTime());
    }

}
