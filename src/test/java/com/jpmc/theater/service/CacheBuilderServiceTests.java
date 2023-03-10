package com.jpmc.theater.service;

import com.jpmc.theater.cache.MovieTheaterCache;
import com.jpmc.theater.util.LocalDateProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CacheBuilderServiceTests {

    @Test
    void buildCacheTest(){
    MovieTheaterCache movieTheaterCache = new MovieTheaterCache();
    LocalDateProvider provider=LocalDateProvider.singleton();
    CacheBuilderService cacheBuilderService = new CacheBuilderService(movieTheaterCache);
    cacheBuilderService.buildMoveTheaterCache(provider);
    Assertions.assertEquals(9,movieTheaterCache.getSchedule().size());
    }
}
