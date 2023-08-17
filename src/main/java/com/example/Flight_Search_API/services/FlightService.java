package com.example.Flight_Search_API.services;

import com.example.Flight_Search_API.entities.Airport;
import com.example.Flight_Search_API.entities.Flight;
import com.example.Flight_Search_API.repos.FlightRepository;
import com.example.Flight_Search_API.requests.FlightCreateRequest;
import com.example.Flight_Search_API.requests.FlightUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private AirportService airportService;

    public FlightService(FlightRepository flightRepository,AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }


    public Flight createOneFlight(FlightCreateRequest newFlightCreate) {
        Airport departureAirport = airportService.getOneAirportById(newFlightCreate.getDepartureAirportId());
        Airport arrivalAirport = airportService.getOneAirportById(newFlightCreate.getArrivalAirportId());
        if (departureAirport != null && arrivalAirport != null){
            Flight toSave = new Flight();
            toSave.setId(newFlightCreate.getId());
            toSave.setDepartureAirport(departureAirport);
            toSave.setArrivalAirport(arrivalAirport);
            toSave.setDepartureDateTime(newFlightCreate.getDepartureDateTime());
            toSave.setArrivalDateTime(newFlightCreate.getArrivalDateTime());
            toSave.setPrice(newFlightCreate.getPrice());
            return flightRepository.save(toSave);
        }else return null;

    }

    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    public Flight getOneFlight(Long flightId) {
        return flightRepository.findById(flightId).orElse(null);
    }

    public Flight updateOneFlight(Long flightId, FlightUpdateRequest updateFlight) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        Airport departureAirport = airportService.getOneAirportById(updateFlight.getDepartureAirportId());
        Airport arrivalAirport = airportService.getOneAirportById(updateFlight.getArrivalAirportId());
        if (flight.isPresent() && departureAirport != null && arrivalAirport !=null){
            Flight toUpdate = flight.get();
            toUpdate.setDepartureAirport(departureAirport);
            toUpdate.setArrivalAirport(arrivalAirport);
            toUpdate.setDepartureDateTime(updateFlight.getDepartureDateTime());
            toUpdate.setArrivalDateTime(updateFlight.getArrivalDateTime());
            toUpdate.setPrice(updateFlight.getPrice());
            return flightRepository.save(toUpdate);
        }else return null;
    }

    public void deleteOneFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
