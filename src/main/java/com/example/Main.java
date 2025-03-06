package com.example;

import com.example.controller.LessonsController;
import com.example.controller.StudentsController;
import com.example.routes.NamedRoutes;
import com.example.util.Log;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
        });

        app.before(Log::log);

        app.get(NamedRoutes.homePath(), ctx -> ctx.render("index.jte"));

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