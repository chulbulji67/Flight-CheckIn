package com.example.flightcheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Passenger{


    private String firstName;
    private String lastName;
    private String middelName;
    private String  email;
    private String phone;
}
