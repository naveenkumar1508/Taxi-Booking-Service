package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private String name;

    private Gender gender;

    private String emailId;
}
