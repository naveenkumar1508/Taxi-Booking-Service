package com.example.GetRide.dto.request;

import com.example.GetRide.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    private int age;

    private String name;

    private String emailId;

    private Gender gender;
}
