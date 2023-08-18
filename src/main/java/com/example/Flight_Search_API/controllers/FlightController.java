package com.example.Flight_Search_API.controllers;

import com.example.Flight_Search_API.entities.Flight;
import com.example.Flight_Search_API.requests.FlightCreateRequest;
import com.example.Flight_Search_API.requests.FlightSearchRequest;
import com.example.Flight_Search_API.requests.FlightUpdateRequest;
import com.example.Flight_Search_API.services.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    @PostMapping
    public Flight createOneFlight(@RequestBody FlightCreateRequest newFlightCreate){
        return flightService.createOneFlight(newFlightCreate);
    }
    @GetMapping("/search")
    public List<Flight> searchFlight(@RequestPart FlightSearchRequest flightSearchRequest){
        return flightService.searchFlights(flightSearchRequest);
    }
    @GetMapping("/{flightId}")
    public Flight getOneFlight(@PathVariable Long flightId){
        return flightService.getOneFlight(flightId);
    }

    @PutMapping("/{flightId}")
    public Flight updateOneFlight(@PathVariable Long flightId, @RequestBody FlightUpdateRequest updateFlight){
        return flightService.updateOneFlight(flightId,updateFlight);
    }
    @DeleteMapping("/{flightId}")
    public void deleteOneFlight(@PathVariable Long flightId){
        flightService.deleteOneFlight(flightId);
    }



}
