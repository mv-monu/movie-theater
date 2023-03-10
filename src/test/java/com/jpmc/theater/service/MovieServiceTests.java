package com.jpmc.theater.service;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieServiceTests {


    @Test
    void specialMovieWith50PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        MovieService movieService = new MovieService();
        assertEquals(10, movieService.calculateTicketPrice(spiderMan,showing));
    }

    @Test
    void specialMovieWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        MovieService movieService = new MovieService();
        assertEquals(9.375, movieService.calculateTicketPrice(spiderMan,showing));
    }

    @Test
    void specialMovieWith3DollarDiscount1seq() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        MovieService movieService = new MovieService();
        assertEquals(9.5, movieService.calculateTicketPrice(spiderMan,showing));
    }

    @Test
    void specialMovieWith2DollarDiscount2seq() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        MovieService movieService = new MovieService();
        assertEquals(10.5, movieService.calculateTicketPrice(spiderMan,showing));
    }

    @Test
    void specialMovieWith1DollarDiscount7seq() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        MovieService movieService = new MovieService();
        assertEquals(11.5, movieService.calculateTicketPrice(spiderMan,showing));
    }

    @Test
    void noDiscountMovie() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        MovieService movieService = new MovieService();
        assertEquals(12.5, movieService.calculateTicketPrice(spiderMan,showing));
    }
}
