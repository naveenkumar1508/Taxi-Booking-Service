package com.example.GetRide.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverRequest {


    String name;

    int age;

    String drivingLiscense;

    Long mobileNumber;


    CabRequest cabRequest;


}
