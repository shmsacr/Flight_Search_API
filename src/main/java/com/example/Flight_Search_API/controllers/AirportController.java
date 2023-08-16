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

    @GetMapping("/{airportId}")
    public Airport getOneAirport(@PathVariable Long airportId){
        return airportService.getOneAirportById(airportId);
    }
    @PutMapping("/{airportId}")
    public Airport updateOneAirport(@PathVariable Long airportId,@RequestBody Airport newAirport){
        return airportService.updateOneAirport(airportId,newAirport);
    }
    @DeleteMapping("/{airportId}")
    public void deleteOneAirport(@PathVariable Long airportId){
        airportService.deleteOneAirport(airportId);
    }

}
