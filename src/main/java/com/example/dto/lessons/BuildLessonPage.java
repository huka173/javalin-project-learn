package com.example.dto.lessons;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class BuildLessonPage {
    private String nameLesson;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;
}
