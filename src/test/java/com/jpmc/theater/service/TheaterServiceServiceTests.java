package com.jpmc.theater.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.util.LocalDateProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterServiceServiceTests {
    @Test
    void totalFeeForCustomer() {
        TheaterService theaterService = new TheaterService(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theaterService.reserve(john, 2, 4);
        assertEquals(reservation.totalFee(), 50);
    }

    @Test
    void printMovieSchedule() throws JsonProcessingException {
        TheaterService theaterService = new TheaterService(LocalDateProvider.singleton());
        String printSchedule = theaterService.getPrintSchedule();
        Assertions.assertNotNull(printSchedule);
    }
}
