package com.chase.match.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Applicants {

    private String birthDate;
    private String lastName;
    private String socialSecurityNumber;
    private String subjectSSN_SIN;
    private Address address;
}
