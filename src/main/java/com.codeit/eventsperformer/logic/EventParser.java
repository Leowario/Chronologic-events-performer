package com.codeit.eventsperformer.logic;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeit.eventsperformer.logic.MillisecondsParser.parseToMillis;

/**
 * @author Vitalii Usatyi
 *         <p>
 *         Parses from JSON file to array of {@link Event}
 */
public class EventParser {

    public Event[] parse() throws URISyntaxException, IOException, ParseException {
        JSONArray jsonObject = getJsonArrayObject();
        String jsonString = jsonObject.toJSONString();
        Event[] events = new Gson().fromJson(jsonString, Event[].class);
        for (Event event : events) {
            event.setTimeMillis(parseToMillis(event.getTime()));
        }
        return events;
    }

    private JSONArray getJsonArrayObject() throws URISyntaxException, IOException, ParseException {
        Path path = getPath();
        File file = new File(path.toUri());
        return getJsonArrayObject(file);
    }

    private static JSONArray getJsonArrayObject(File file) throws IOException, ParseException {
        return (JSONArray) new JSONParser().parse(new FileReader(file));
    }

    private Path getPath() throws URISyntaxException {
        return Paths.get(
                getClass()
                        .getClassLoader()
                        .getResource("events.json").toURI());
    }
}
