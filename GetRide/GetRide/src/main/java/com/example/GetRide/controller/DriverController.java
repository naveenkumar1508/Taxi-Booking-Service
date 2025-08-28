package com.example.GetRide.controller;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest) {

        String response = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public DriverResponse getDriver(@RequestParam("mobileNumber") long mobileNumber) {
        return driverService.getDriver(mobileNumber);
    }

    //get all the drivers above a particular age

    //get the driver with maximum number of bookings

    //update the driver liscense
    //update driver number

    //driver with least number of bookings

    //get all the drivers with less than 10 bookings
}
