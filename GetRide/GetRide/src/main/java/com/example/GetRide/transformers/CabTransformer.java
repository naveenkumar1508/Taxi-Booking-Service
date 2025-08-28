package com.example.GetRide.transformers;

import com.example.GetRide.dto.request.CabRequest;
import com.example.GetRide.dto.response.CabResponse;
import com.example.GetRide.model.Cab;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest) {
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabType(cabRequest.getCabType())
                .farePerKm(cabRequest.getFarePerKm())
                .booked(false)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab) {
        return CabResponse.builder()
                .cabType(cab.getCabType())
                .farePerKm(cab.getFarePerKm())
                .cabNumber(cab.getCabNumber())
                .booked(cab.isBooked())
                .build();
    }
}
