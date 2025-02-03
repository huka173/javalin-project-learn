package com.example;

import com.example.dto.lessons.LessonPage;
import com.example.dto.lessons.LessonsPage;
import com.example.model.Lesson;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.javalin.rendering.template.TemplateUtil.model;

public class Main {
    public static void main(String[] args) {
        List<Lesson> arrLessons = new ArrayList<>(List.of(
                new Lesson(1L, "Mathematics", "Statistical Analysis for Social Sciences: Master statistical methods and their application in social sciences research."),
                new Lesson(2L, "Physics", "Classical Mechanics for Experimental Research"),
                new Lesson(3L, "Chemistry", "Organic Chemistry for Pharmaceutical Applications"),
                new Lesson(4L, "Computer Science", "Programming in Python for Data Science"),
                new Lesson(5L, "Economics", "Behavioral Economics for Consumer Psychology: Explore how psycholog")
        ));

        Javalin app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/lessons", ctx -> {
            var page = new LessonsPage(arrLessons);
            ctx.render("lessons/lessons.jte", model("page", page));
        });

        app.get("/lessons/{id}", ctx -> {
            var id = ctx.pathParam("id");
            System.out.println(id);
            var page = new LessonPage(arrLessons.stream()
                    .filter(elem -> elem.getId().toString().equals(id))
                    .findFirst()
                    .get());

            ctx.render("lessons/lesson.jte", model("page", page));
        });


        app.start(7070);
    }
}