package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Lesson {
    private Long id;

    private String nameLesson;
    private String description;

    public Lesson(String nameLesson, String description) {
        this.nameLesson = nameLesson;
        this.description = description;
    }
}
