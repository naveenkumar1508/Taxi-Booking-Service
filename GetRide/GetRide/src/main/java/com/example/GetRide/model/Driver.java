package com.example.GetRide.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
    private Cab cab;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();
}
