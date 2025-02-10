package com.example.repository;

import com.example.model.Lesson;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class LessonRepository {
    private static List<Lesson> entities = new ArrayList<>(List.of(
            new Lesson(1L, "Mathematics", "Statistical Analysis for Social Sciences: Master statistical methods and their application in social sciences research."),
            new Lesson(2L, "Physics", "Classical Mechanics for Experimental Research"),
            new Lesson(3L, "Chemistry", "Organic Chemistry for Pharmaceutical Applications"),
            new Lesson(4L, "Computer Science", "Programming in Python for Data Science"),
            new Lesson(5L, "Economics", "Behavioral Economics for Consumer Psychology: Explore how psycholog")
    ));

    public static void save(Lesson lesson) {
        lesson.setId((long) entities.size() + 1);
        entities.add(lesson);
    }

    public static List<Lesson> search(String str) {
        var lowerStr = str.toLowerCase();
        return entities.stream()
                .filter(elem -> elem.getNameLesson().toLowerCase().startsWith(lowerStr))
                .toList();
    }

    public static Optional<Lesson> find(Long id) {
        return entities.stream()
                .filter(elem -> elem.getId().equals(id))
                .findAny();
    }
}
