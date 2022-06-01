package com.chase.match.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {

    private String apartmentNumber;
    private String poBoxNumber;
    private String ruralRouteNumber;
    private String streetNumber;
    private String streetName;
    private String streetType;
    private String city;
    private String state;
    private String zipCode;

}
