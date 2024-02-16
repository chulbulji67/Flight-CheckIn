package com.example.flightcheckin.integration;

import com.example.flightcheckin.dto.ReservaionUpdateRequest;
import com.example.flightcheckin.dto.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationRestClient {

    public Reservation findReservation(long id);


    Reservation updateReservation(ReservaionUpdateRequest reservaionUpdateRequest);
}
