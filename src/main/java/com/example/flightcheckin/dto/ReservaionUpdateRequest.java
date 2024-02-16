package com.example.flightcheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaionUpdateRequest {

    private long id;
    private Boolean checkedIn;

    private int numberOfBags;
}
