package com.example.Flight_Search_API.services;

import com.example.Flight_Search_API.entities.Airport;
import com.example.Flight_Search_API.repos.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport saveOneAirport(Airport newAirport) {
        return airportRepository.save(newAirport);
    }
}
