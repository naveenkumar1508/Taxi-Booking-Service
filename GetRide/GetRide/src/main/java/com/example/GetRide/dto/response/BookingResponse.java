package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.BookingStatus;
import lombok.*;


import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    private String bookingId; //UUID

    private String pickUp;

    private String destination;


    private BookingStatus bookingStatus;

    private double totalDistance;

    private double totalFare;

    private Date date;

    private CustomerResponse customerResponse;

    private DriverResponse driverResponse;

}
