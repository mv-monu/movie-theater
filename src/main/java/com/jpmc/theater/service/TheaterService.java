package com.jpmc.theater.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jpmc.theater.cache.MovieTheaterCache;
import com.jpmc.theater.exception.MovieTheaterException;
import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.util.LocalDateProvider;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TheaterService {
    LocalDateProvider provider;
    MovieTheaterCache movieTheaterCache;
    ObjectMapper mapper = new ObjectMapper();

    public TheaterService(LocalDateProvider provider) {
        this.provider = provider;
        movieTheaterCache = new MovieTheaterCache();
        CacheBuilderService cacheBuilderService = new CacheBuilderService(movieTheaterCache);
        cacheBuilderService.buildMoveTheaterCache(provider);
    }

    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Showing showing;
        try {
            showing = movieTheaterCache.getSchedule().get(sequence - 1);
        } catch (MovieTheaterException ex) {
            throw new MovieTheaterException("not able to find any showing for given sequence " + sequence,ex);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    public String getPrintSchedule() throws JsonProcessingException {
        log.info("Schedule for date : {} ",provider.currentDate());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<String> scheduleLists = new ArrayList<>();

        movieTheaterCache.getSchedule().forEach(s ->
                scheduleLists.add(s.getSequenceOfTheDay() + ": " + s.getShowStartTime() + " " + s.getMovie().getTitle() + " " + s.getMovie().getRunningTimeFormat() + " $" + s.getMovieFee())
        );
        return mapper.writeValueAsString(scheduleLists);
    }

    public static void main(String[] args) throws JsonProcessingException {
        TheaterService theaterService = new TheaterService(LocalDateProvider.singleton());
        log.info("===================================================");
        log.info(theaterService.getPrintSchedule());
        log.info("===================================================");
    }
}
