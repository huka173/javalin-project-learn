package com.example.controller;

import com.example.dto.lessons.BuildLessonPage;
import com.example.dto.lessons.LessonPage;
import com.example.dto.lessons.LessonsPage;
import com.example.model.Lesson;
import com.example.repository.LessonRepository;
import com.example.util.Sanitizer;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class LessonsController {
    public static void index(Context ctx) {
        var search = ctx.queryParam("search");
        String safeHTML = Sanitizer.sanitize(search).toLowerCase().strip();

        List<Lesson> searchArr = LessonRepository.search(safeHTML);
        var page = new LessonsPage(searchArr, search, ctx.consumeSessionAttribute("flashLesson"));
        ctx.render("layout/lessons/lessons.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildLessonPage();
        ctx.render("layout/lessons/build.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParam("id");
        String safeHTML = Sanitizer.sanitize(id).toLowerCase().strip();

        try {
            var page = new LessonPage(LessonRepository.find(Long.parseLong(safeHTML)).orElseThrow());
            ctx.render("layout/lessons/lesson.jte", model("page", page));
        } catch (Exception e) {
            throw new NotFoundResponse("Not found this lesson");
        }
    }

    public static void create(Context ctx) {
        try {
            var nameLesson = ctx.formParamAsClass("nameLesson", String.class)
                    .check(value -> value.length() > 2, "Name of the lesson is too short")
                    .get();

            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Description is too small")
                    .get();

            var safeName = StringUtils.capitalize(Sanitizer.sanitize(nameLesson).strip());
            var safeDes = StringUtils.capitalize(Sanitizer.sanitize(description).strip());
            var lesson = new Lesson(safeName, safeDes);
            LessonRepository.save(lesson);
            ctx.sessionAttribute("flashLesson", "Lesson has been created!");
            ctx.redirect("/lessons");
        } catch (ValidationException e) {
            var nameLesson = ctx.formParam("nameLesson");
            var description = ctx.formParam("description");
            var page = new BuildLessonPage(nameLesson, description, e.getErrors());
            ctx.render("layout/lessons/build.jte", model("page", page));
        }
    }
}
