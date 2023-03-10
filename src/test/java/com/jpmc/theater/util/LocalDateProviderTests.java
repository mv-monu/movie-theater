package com.jpmc.theater.util;

import com.jpmc.theater.util.LocalDateProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * The type Local date provider tests.
 */
public class LocalDateProviderTests {
    /**
     * Make sure current time.
     */
    @Test
    void makeSureCurrentTime() {
        LocalDate now = LocalDate.now();
        LocalDate current = LocalDateProvider.singleton().currentDate();
        Assertions.assertTrue(now.isEqual(LocalDate.from(current)));
    }
}
