package com.jpmc.theater.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * The type Common utils.
 */
public class CommonUtils {

    /**
     * Human readable format string.
     *
     * @param duration the duration
     * @return the string
     */
    public static String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    /**
     * Handle plural string.
     *
     * @param value the value
     * @return the string
     */
// (s) postfix should be added to handle plural correctly
    public static String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }
}
