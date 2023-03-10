package com.jpmc.theater.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpmc.theater.model.Movie;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * The type Showing.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Showing {
    Movie movie;
    int sequenceOfTheDay;
    LocalDateTime showStartTime;

    /**
     * Is sequence boolean.
     *
     * @param sequence the sequence
     * @return the boolean
     */
    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    /**
     * Gets movie fee.
     *
     * @return the movie fee
     */
    public double getMovieFee() {
        return movie.getTicketPrice();
    }
}
