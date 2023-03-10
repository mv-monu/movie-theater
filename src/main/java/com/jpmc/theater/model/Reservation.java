package com.jpmc.theater.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * The type Reservation.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Reservation {
    Customer customer;
    Showing showing;
    int audienceCount;

    /**
     * Total fee double.
     *
     * @return the double
     */
    public double totalFee() {
        return showing.getMovieFee() * audienceCount;
    }
}