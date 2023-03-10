package com.jpmc.theater.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    public double totalFee() {
        return showing.getMovieFee() * audienceCount;
    }
}