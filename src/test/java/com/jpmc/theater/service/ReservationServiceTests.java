package com.jpmc.theater.service;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Reservation service tests.
 */
public class ReservationServiceTests {

    /**
     * Total fee.
     */
    @Test
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        Reservation reservation = new Reservation(customer, showing, 3);
        ReservationService reservationService = new ReservationService();
        assertEquals(reservationService.totalFee(reservation) , 37.5);
    }

    /**
     * No audience.
     */
    @Test
    void noAudience() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        Reservation reservation = new Reservation(customer, showing, 0);
        ReservationService reservationService = new ReservationService();
        assertEquals(reservationService.totalFee(reservation) , 0);
    }
}
