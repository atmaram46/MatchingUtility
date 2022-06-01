package com.chase.match.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDetails {
    private Applicants[] applicants;
    private String[] phones;
}
