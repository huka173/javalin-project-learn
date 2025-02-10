package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
