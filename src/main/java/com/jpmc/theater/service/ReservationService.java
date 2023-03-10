package com.jpmc.theater.service;

import com.jpmc.theater.model.Reservation;
import lombok.extern.slf4j.Slf4j;

/**
 * The type Reservation service.
 */
@Slf4j
public class ReservationService {

    /**
     * Total fee double.
     *
     * @param reservation the reservation
     * @return the double
     */
    public double totalFee(Reservation reservation) {
        return reservation.getShowing().getMovieFee() * reservation.getAudienceCount();
    }
}
