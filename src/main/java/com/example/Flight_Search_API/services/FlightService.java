package com.example.Flight_Search_API.services;

import com.example.Flight_Search_API.entities.Flight;
import com.example.Flight_Search_API.repos.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }
}
