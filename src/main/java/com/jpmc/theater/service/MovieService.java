package com.jpmc.theater.service;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.util.Constants;
import lombok.extern.slf4j.Slf4j;

import java.time.temporal.ValueRange;

/**
 * The type Movie service.
 */
@Slf4j
public class MovieService {

    /**
     * Calculate ticket price double.
     *
     * @param movie   the movie
     * @param showing the showing
     * @return the double
     */
    public double calculateTicketPrice(Movie movie,Showing showing) {
        return movie.getTicketPrice() - getDiscount(movie,showing);
    }

    private double getDiscount(Movie movie,Showing showing) {
        int showSequence = showing.getSequenceOfTheDay();
        double specialDiscount = 0;
        if (Constants.MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
            specialDiscount = movie.getTicketPrice() * 0.2;  // 20% discount for special movie
        }
        //25% discount apply if movie showing starting between 11AM ~ 4pm.
        ValueRange range = ValueRange.of(9, 16);
        if(range.isValidIntValue(showing.getShowStartTime().getHour())){
            specialDiscount = movie.getTicketPrice() * 0.25;
        }
        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {

            sequenceDiscount = 2; // $2 discount for 2nd show
        } else if (showSequence == 7){
            sequenceDiscount = 1; // Any movies showing on 7th, you'll get 1$ discount
        }
        // biggest discount wins
        return Math.max(specialDiscount , sequenceDiscount);
    }
}
