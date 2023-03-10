package com.jpmc.theater.service;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.Movie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class ShowingService {

    MovieService movieService;

    public boolean isSequence(Showing showing,int sequence) {
        return showing.getSequenceOfTheDay() == sequence;
    }

    public double getMovieFee(Showing showing) {
        // Null check require
        return showing.getMovie().getTicketPrice();
    }

    public double calculateFee(Showing showing, Movie movie,int audienceCount) {
        return movieService.calculateTicketPrice(movie,showing) * audienceCount;
    }
}
