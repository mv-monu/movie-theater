package com.jpmc.theater.util;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.time.Duration;

/**
 * The type Common utils tests.
 */
public class CommonUtilsTests {

    /**
     * Human readable format test notnull.
     */
    @Test
    void humanReadableFormatTest_notnull(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(90));
        Assertions.assertNotNull(formatString);
    }

    /**
     * Human readable format test minuteplural.
     */
    @Test
    void humanReadableFormatTest_minuteplural(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(90));
        Assertions.assertTrue(formatString.contains("minutes"));
    }

    /**
     * Human readable format test hourplural.
     */
    @Test
    void humanReadableFormatTest_hourplural(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(121));
        Assertions.assertTrue(formatString.contains("hours"));
    }

    /**
     * Human readable format test hoursingular.
     */
    @Test
    void humanReadableFormatTest_hoursingular(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(90));
        Assertions.assertTrue(formatString.contains("hour"));
    }

    /**
     * Human readable format test minutesingular.
     */
    @Test
    void humanReadableFormatTest_minutesingular(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(61));
        Assertions.assertTrue(formatString.contains("minute"));
    }
}
