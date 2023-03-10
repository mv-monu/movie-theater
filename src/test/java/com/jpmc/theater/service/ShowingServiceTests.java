package com.jpmc.theater.service;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Showing service tests.
 */
public class ShowingServiceTests {

    /**
     * Is sequence test.
     */
    @Test
    void isSequenceTest(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        MovieService movieService = new MovieService();
        ShowingService showingService = new ShowingService(movieService);
        Assertions.assertTrue(showingService.isSequence(showing,1));
    }

    /**
     * Get movie fee test.
     */
    @Test
    void getMovieFeeTest(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        MovieService movieService = new MovieService();
        ShowingService showingService = new ShowingService(movieService);
        Assertions.assertEquals(showingService.getMovieFee(showing),12.5);
    }

    /**
     * Calculate fee for person.
     */
    @Test
    void calculateFeeForPerson() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        MovieService movieService = new MovieService();
        ShowingService showingService = new ShowingService(movieService);
        assertEquals(9.5, showingService.calculateFee(showing,spiderMan,1));
    }
}
