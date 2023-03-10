package com.jpmc.theater.cache;

import com.jpmc.theater.model.Showing;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The type Movie theater cache.
 */
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class MovieTheaterCache {
    private final List<Showing> schedule = new CopyOnWriteArrayList<>();
}
