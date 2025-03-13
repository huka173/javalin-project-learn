package com.example.dto.lessons;

import com.example.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class LessonsPage {
    private List<Lesson> lessons;
    private String search;
    private String flash;
}
