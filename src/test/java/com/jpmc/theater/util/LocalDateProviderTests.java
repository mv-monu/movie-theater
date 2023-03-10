package com.jpmc.theater.util;

import com.jpmc.theater.util.LocalDateProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LocalDateProviderTests {
    @Test
    void makeSureCurrentTime() {
        LocalDate now = LocalDate.now();
        LocalDate current = LocalDateProvider.singleton().currentDate();
        Assertions.assertTrue(now.isEqual(LocalDate.from(current)));
    }
}
