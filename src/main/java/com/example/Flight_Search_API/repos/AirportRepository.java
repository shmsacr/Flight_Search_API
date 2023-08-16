package com.example.Flight_Search_API.repos;

import com.example.Flight_Search_API.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
