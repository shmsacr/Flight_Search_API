package com.example.Flight_Search_API.controllers;

import com.example.Flight_Search_API.entities.Airport;
import com.example.Flight_Search_API.services.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    private AirportService airportService;


    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }
    @GetMapping
    public List<Airport> getAllAirports(){
        return airportService.getAllAirports();
    }

    @PostMapping
    public Airport addAirport(@RequestBody Airport newAirport){
        return airportService.saveOneAirport(newAirport);
    }

}
