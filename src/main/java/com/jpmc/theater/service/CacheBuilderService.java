package com.jpmc.theater.service;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.cache.MovieTheaterCache;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.util.LocalDateProvider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * The type Cache builder service.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class CacheBuilderService {

    MovieTheaterCache movieTheaterCache;

    /**
     * Build move theater cache.
     *
     * @param provider the provider
     */
    public void buildMoveTheaterCache(LocalDateProvider provider){
       if(movieTheaterCache!=null){
           movieTheaterCache.getSchedule().clear();
           Movie spiderMan = new Movie("Spider-Man: No Way Home","Marvel Movie", Duration.ofMinutes(90), 12.5, 1);
           Movie turningRed = new Movie("Turning Red","Comedy Movie", Duration.ofMinutes(85), 11, 0);
           Movie theBatMan = new Movie("The Batman","DC Movie", Duration.ofMinutes(95), 9, 0);
           movieTheaterCache.getSchedule().addAll(List.of(
                   new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
                   new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
                   new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
                   new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
                   new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
                   new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
                   new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
                   new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
                   new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
           ));
       }else {
           log.error("Cache Object can not be null");
       }
    }
}
