package com.example.flightcheckin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation{



    private Boolean checkedIn;

    private int numberOFBags;

    private Passenger passenger;

    private Flight flight;
}
