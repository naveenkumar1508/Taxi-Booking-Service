package com.example.GetRide.repository;

import com.example.GetRide.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Driver findByMobileNumber(long mobilNumber);

}
