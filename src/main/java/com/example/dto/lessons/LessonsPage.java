package com.example.dto.lessons;

import com.example.model.Lesson;

import java.util.List;

public class LessonsPage {
    private List<Lesson> arrLessons;

    public LessonsPage(List<Lesson> arrLessons) {
        this.arrLessons = arrLessons;
    }

    public List<Lesson> getArrLessons() {
        return arrLessons;
    }
}
