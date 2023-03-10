package com.jpmc.theater.service;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.Movie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The type Showing service.
 */
@AllArgsConstructor
@Slf4j
public class ShowingService {

    /**
     * The Movie service.
     */
    MovieService movieService;

    /**
     * Is sequence boolean.
     *
     * @param showing  the showing
     * @param sequence the sequence
     * @return the boolean
     */
    public boolean isSequence(Showing showing,int sequence) {
        return showing.getSequenceOfTheDay() == sequence;
    }

    /**
     * Gets movie fee.
     *
     * @param showing the showing
     * @return the movie fee
     */
    public double getMovieFee(Showing showing) {
        // Null check require
        return showing.getMovie().getTicketPrice();
    }

    /**
     * Calculate fee double.
     *
     * @param showing       the showing
     * @param movie         the movie
     * @param audienceCount the audience count
     * @return the double
     */
    public double calculateFee(Showing showing, Movie movie,int audienceCount) {
        return movieService.calculateTicketPrice(movie,showing) * audienceCount;
    }
}
