package com.codeit.eventsperformer.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Vitalii Usatii
 */
class MillisecondsParser {

    private static final int CONSTANT = 7200000;

    /**
     * @param time should contain time in format(mm:ss)
     * @return milliseconds of the entered time
     */
    static long parseToMillis(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("mm:ss");
            format.setTimeZone(TimeZone.getDefault());
            Date date = format.parse(time);
            return date.getTime() + CONSTANT;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Incorrect time entry");
    }
}
