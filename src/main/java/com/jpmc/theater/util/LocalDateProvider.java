package com.jpmc.theater.util;

import java.time.LocalDate;

/**
 * The type Local date provider.
 */
public class LocalDateProvider {
    private static LocalDateProvider instance = null;

    /**
     * Singleton local date provider.
     *
     * @return make sure to return singleton instance
     */
    public static LocalDateProvider singleton() {
        if (instance == null) {
            instance = new LocalDateProvider();
        }
            return instance;
        }

    /**
     * Current date local date.
     *
     * @return the local date
     */
    public LocalDate currentDate() {
            return LocalDate.now();
    }
}
