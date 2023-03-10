package com.jpmc.theater.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpmc.theater.util.CommonUtils;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;

/**
 * The type Movie.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    /**
     * Gets running time format.
     *
     * @return the running time format
     */
    public String getRunningTimeFormat() {
        return  CommonUtils.humanReadableFormat(this.runningTime);
    }
}