package com.jpmc.theater.util;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.time.Duration;

public class CommonUtilsTests {

    @Test
    void humanReadableFormatTest_notnull(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(90));
        Assertions.assertNotNull(formatString);
    }

    @Test
    void humanReadableFormatTest_minuteplural(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(90));
        Assertions.assertTrue(formatString.contains("minutes"));
    }

    @Test
    void humanReadableFormatTest_hourplural(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(121));
        Assertions.assertTrue(formatString.contains("hours"));
    }
    @Test
    void humanReadableFormatTest_hoursingular(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(90));
        Assertions.assertTrue(formatString.contains("hour"));
    }
    @Test
    void humanReadableFormatTest_minutesingular(){
        String formatString = CommonUtils.humanReadableFormat(Duration.ofMinutes(61));
        Assertions.assertTrue(formatString.contains("minute"));
    }
}
