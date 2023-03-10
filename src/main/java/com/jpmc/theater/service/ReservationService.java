package com.jpmc.theater.service;

import com.jpmc.theater.model.Reservation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReservationService {

    public double totalFee(Reservation reservation) {
        return reservation.getShowing().getMovieFee() * reservation.getAudienceCount();
    }
}
