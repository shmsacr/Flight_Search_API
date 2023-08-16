package com.example.Flight_Search_API.controllers;

import com.example.Flight_Search_API.entities.Flight;
import com.example.Flight_Search_API.services.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    @GetMapping
    public List<Flight> getAllFlight(){
        return flightService.getAllFlight();
    }
}
