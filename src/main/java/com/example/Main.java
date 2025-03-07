package com.example;

import com.example.controller.LessonsController;
import com.example.controller.StudentsController;
import com.example.dto.MainPage;
import com.example.routes.NamedRoutes;
import com.example.util.Log;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
        });

        app.before(Log::log);

        app.get(NamedRoutes.homePath(), ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("index.jte", model("visit", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        app.get(NamedRoutes.lessonsPath(), LessonsController::index);

        app.get(NamedRoutes.lessonsBuildPath(), LessonsController::build);

        app.get(NamedRoutes.lessonPath("{id}"), LessonsController::show);

        app.post(NamedRoutes.lessonsPath(), LessonsController::create);

        app.get(NamedRoutes.studentsPath(), StudentsController::index);

        app.get(NamedRoutes.studentsBuildPath(), StudentsController::build);

        app.get(NamedRoutes.studentPath("{id}"), StudentsController::show);

        app.post(NamedRoutes.studentsPath(), StudentsController::create);

        app.start(7070);
    }
}