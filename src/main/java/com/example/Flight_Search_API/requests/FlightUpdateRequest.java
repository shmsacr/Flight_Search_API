package com.example.Flight_Search_API.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FlightUpdateRequest {
    Long departureAirportId;
    Long arrivalAirportId;
    LocalDate departureDateTime;
    LocalDate arrivalDateTime;
    double price;
}
