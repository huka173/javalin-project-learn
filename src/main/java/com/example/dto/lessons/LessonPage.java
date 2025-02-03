package com.example.dto.lessons;

import com.example.model.Lesson;

public class LessonPage {
    private Lesson lesson;

    public LessonPage(Lesson lesson) {
        this.lesson = lesson;
    }

    public Lesson getLesson() {
        return lesson;
    }
}
