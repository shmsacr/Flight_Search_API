package com.example.Flight_Search_API.repos;

import com.example.Flight_Search_API.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
