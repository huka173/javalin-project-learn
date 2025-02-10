package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Lesson {
    private Long id;
    private String nameLesson;
    private String description;
}
