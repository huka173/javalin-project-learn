package com.example.dto.lessons;

import com.example.model.Lesson;

import java.util.List;

public class LessonsPage {
    private List<Lesson> lessons;
    private String search;

    public LessonsPage(List<Lesson> lessons, String search) {
        this.lessons = lessons;
        this.search = search;
    }

    public List<Lesson> getArrLessons() {
        return lessons;
    }

    public String getSearch() {
        return search;
    }
}
