package com.example.GetRide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    private int age;

    @Column(unique = true, nullable = false)
    private String drivingLiscense;

    @Column(unique = true,nullable = false)
    private long mobileNumber;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    private Cab cab;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();
}
