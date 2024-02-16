package com.example.flightcheckin.integration;

import com.example.flightcheckin.dto.ReservaionUpdateRequest;
import com.example.flightcheckin.dto.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationRestClientImpl implements ReservationRestClient{


    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Reservation findReservation(long id) {

        Reservation reservation = restTemplate.getForObject("http://localhost:8081/reservations/"+id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservaionUpdateRequest reservaionUpdateRequest) {

//        restTemplate.put("http://localhost:8081/reservations",reservaionUpdateRequest);
        Reservation reservation = restTemplate.postForObject("http://localhost:8081/reservations", reservaionUpdateRequest, Reservation.class);
        return reservation;
    }
}
