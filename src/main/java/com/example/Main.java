package com.example;

import com.example.dto.lessons.BuildLessonPage;
import com.example.dto.lessons.LessonPage;
import com.example.dto.lessons.LessonsPage;
import com.example.dto.students.BuildStudentPage;
import com.example.dto.students.StudentPage;
import com.example.dto.students.StudentsPage;
import com.example.model.Lesson;
import com.example.model.Student;
import com.example.repository.LessonRepository;
import com.example.repository.StudentRepository;
import com.example.util.Sanitizer;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;

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
            String safeHTML = Sanitizer.sanitize(search).toLowerCase().strip();

            List<Lesson> searchArr = LessonRepository.search(safeHTML);
            var page = new LessonsPage(searchArr, search);
            ctx.render("layout/lessons/lessons.jte", model("page", page));
        });

        app.get("/lessons/build", ctx -> {
            var page = new BuildLessonPage();
            ctx.render("layout/lessons/build.jte", model("page", page));
        });

        app.get("/lessons/{id}", ctx -> {
            var id = ctx.pathParam("id");
            String safeHTML = Sanitizer.sanitize(id).toLowerCase().strip();

            try {
                var page = new LessonPage(LessonRepository.find(Long.parseLong(safeHTML)).orElseThrow());
                ctx.render("layout/lessons/lesson.jte", model("page", page));
            } catch (Exception e) {
                throw new NotFoundResponse("Not found this lesson");
            }
        });

        app.post("/lessons", ctx -> {
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
                ctx.redirect("/lessons");
            } catch (ValidationException e) {
                var page = new BuildLessonPage(e.getErrors());
                ctx.render("layout/lessons/build.jte", model("page", page));
            }
        });

        app.get("/students", ctx -> {
            var search = ctx.queryParam("search");
            String safeHTML = Sanitizer.sanitize(search).toLowerCase().strip();

            List<Student> searchArr = StudentRepository.search(safeHTML);
            var page = new StudentsPage(searchArr, search);
            ctx.render("layout/students/students.jte", model("page", page));
        });

        app.get("/students/build", ctx -> {
            var page = new BuildStudentPage();
            ctx.render("layout/students/build.jte", model("page", page));
        });

        app.get("/students/{id}", ctx -> {
            var id = ctx.pathParam("id");
            String safeHTML = Sanitizer.sanitize(id).toLowerCase().strip();

            try {
                var page = new StudentPage(StudentRepository.find(Long.parseLong(safeHTML)).orElseThrow());
                ctx.render("layout/students/student.jte", model("page", page));
            } catch (Exception e) {
                throw new NotFoundResponse("Not found this student");
            }
        });

        app.post("/students", ctx -> {
            try {
                var firstName = ctx.formParamAsClass("firstName", String.class)
                        .check(elem -> (elem.length() > 2 && elem.length() < 50), "First name entered incorrectly")
                        .get();


                var lastName = ctx.formParamAsClass("lastName", String.class)
                        .check(elem -> (elem.length() > 2 && elem.length() < 50), "Last name entered incorrectly")
                        .get();

                var email = ctx.formParamAsClass("email", String.class)
                        .check(elem -> elem.length() <= 100 ,"There are a lot of symbols in email")
                        .get();

                var safeFirstName = StringUtils.capitalize(Sanitizer.sanitize(firstName));
                var safeLastName = StringUtils.capitalize(Sanitizer.sanitize(lastName));
                var safeEmail = Sanitizer.sanitize(email).toLowerCase().strip();

                var student = new Student(safeFirstName, safeLastName, safeEmail);
                StudentRepository.save(student);
                ctx.redirect("/students");
            } catch (ValidationException e) {
                var page = new BuildStudentPage(e.getErrors());
                ctx.render("layout/students/build.jte", model("page", page));
            }

        });

        app.start(7070);
    }
}