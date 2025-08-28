package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.CabType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {

    String cabNumber;

    CabType cabType;

    double farePerKm;

    boolean booked;
}
