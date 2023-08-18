package com.example.Flight_Search_API.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FlightSearchRequest {
    private String departure;
    private String arrival;
    private LocalDate departureDate;
    private LocalDate returnDate;

}
