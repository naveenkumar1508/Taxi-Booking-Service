package com.example.GetRide.transformers;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .drivingLiscense(driverRequest.getDrivingLiscense())
                .mobileNumber(driverRequest.getMobileNumber())
                .build();
    }

    public static DriverResponse DriverToDriverResponse(Driver driver) {
        return DriverResponse.builder()
                .mobileNumber(driver.getMobileNumber())
                .name(driver.getName())
                .cab(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
