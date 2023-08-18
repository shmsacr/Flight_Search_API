package com.example.Flight_Search_API.repos;

import com.example.Flight_Search_API.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query("SELECT a FROM Flight a " +
            "WHERE a.departureAirport.city = :departureAirport " +
            "AND a.arrivalAirport.city = :arrivalAirport " +
            "AND a.departureDateTime= :departureDate"
            )
    List<Flight> findFlightByDetails(@Param("departureAirport") String departureAirport,@Param("arrivalAirport") String arrivalAirport,@Param("departureDate") LocalDate departureDate);
//    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTime(String departure, String arrival, LocalDate departureDateTime);
}
