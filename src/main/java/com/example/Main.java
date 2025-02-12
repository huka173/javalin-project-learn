package com.example;

import com.example.dto.lessons.LessonPage;
import com.example.dto.lessons.LessonsPage;
import com.example.dto.students.StudentPage;
import com.example.dto.students.StudentsPage;
import com.example.model.Lesson;
import com.example.model.Student;
import com.example.repository.LessonRepository;
import com.example.repository.StudentRepository;
import com.example.sanitizer.Sanitizer;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/lessons", ctx -> {
            var search = ctx.queryParam("search");
            String safeHTML = Sanitizer.sanitize(search).toLowerCase();

            List<Lesson> searchArr = LessonRepository.search(safeHTML);
            var page = new LessonsPage(searchArr, search);
            ctx.render("layout/lessons/lessons.jte", model("page", page));
        });

        app.get("/lessons/build", ctx -> ctx.render("layout/lessons/build.jte"));

        app.get("/lessons/{id}", ctx -> {
            var id = ctx.pathParam("id");
            String safeHTML = Sanitizer.sanitize(id).toLowerCase();

            try {
                var page = new LessonPage(LessonRepository.find(Long.parseLong(safeHTML)).get());
                ctx.render("layout/lessons/lesson.jte", model("page", page));
            } catch (Exception e) {
                throw new NotFoundResponse("Not found this lesson");
            }
        });

        app.post("/lessons", ctx -> {
            var nameLesson = ctx.formParam("nameLesson");
            var description = ctx.formParam("description");

            var safeName = Sanitizer.sanitize(nameLesson);
            var safeDes = Sanitizer.sanitize(description);

            var lesson = new Lesson(safeName, safeDes);
            LessonRepository.save(lesson);
            ctx.redirect("/lessons");
        });

        app.get("/students", ctx -> {
            var search = ctx.queryParam("search");
            String safeHTML = Sanitizer.sanitize(search).toLowerCase();

            List<Student> searchArr = StudentRepository.search(safeHTML);
            var page = new StudentsPage(searchArr, search);
            ctx.render("layout/students/students.jte", model("page", page));
        });

        app.get("/students/build", ctx -> ctx.render("layout/students/build.jte"));

        app.get("/students/{id}", ctx -> {
            var id = ctx.pathParam("id");
            String safeHTML = Sanitizer.sanitize(id).toLowerCase();

            try {
                var page = new StudentPage(StudentRepository.find(Long.parseLong(safeHTML)).get());
                ctx.render("layout/students/student.jte", model("page", page));
            } catch (Exception e) {
                throw new NotFoundResponse("Not found this student");
            }
        });

        app.post("/students", ctx -> {
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var email = ctx.formParam("email");

            var safeFirstName = Sanitizer.sanitize(firstName);
            var safeLastName = Sanitizer.sanitize(lastName);
            var safeEmail = Sanitizer.sanitize(email);

            var student = new Student(safeFirstName, safeLastName, safeEmail);
            StudentRepository.save(student);
            ctx.redirect("/students");
        });

        app.start(7070);
    }
}