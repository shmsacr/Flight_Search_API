package com.example.Flight_Search_API.services;

import com.example.Flight_Search_API.entities.Airport;
import com.example.Flight_Search_API.repos.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

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

    public Airport getOneAirportById(Long airportId) {
        return airportRepository.findById(airportId).orElse(null);
    }

    public Airport updateOneAirport(Long airportId, Airport newAirport) {
        Optional<Airport> airport = airportRepository.findById(airportId);
        if(airport.isPresent()){
            Airport founderAirport = airport.get();
            founderAirport.setCity(newAirport.getCity());
            return airportRepository.save(founderAirport);
        }else return null;
    }

    public void deleteOneAirport(Long airportId) {
        airportRepository.deleteById(airportId);
    }
}
