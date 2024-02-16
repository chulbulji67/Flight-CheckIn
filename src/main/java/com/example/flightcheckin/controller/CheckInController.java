package com.example.flightcheckin.controller;

import com.example.flightcheckin.dto.Reservation;
import com.example.flightcheckin.integration.ReservationRestClient;
import com.example.flightcheckin.util.EmailUtil;
import com.example.flightcheckin.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckInController {

    @Autowired
    ReservationRestClient reservationRestClient;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;
    @GetMapping("/startCheckIn/{reservationID}")
    public Reservation startCheckIN(@PathVariable long reservationID){
        String filePaht = "/Users/chulbul/Documents/reservaions/reservation"+reservationID+".pdf";
        pdfGenerator.generateItinerary(new Reservation(), filePaht);
        emailUtil.sendItinerary("chulbulji67@gmail.com",filePaht);
        return reservationRestClient.findReservation(reservationID);
    }


}
