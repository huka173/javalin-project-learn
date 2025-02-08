package com.example;

import com.example.dto.lessons.LessonPage;
import com.example.dto.lessons.LessonsPage;
import com.example.dto.students.StudentPage;
import com.example.dto.students.StudentsPage;
import com.example.model.Lesson;
import com.example.model.Student;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import java.util.ArrayList;
import java.util.List;

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

        List<Student> arrStudents = new ArrayList<>(List.of(
                new Student(1L, "Andrew", "Brown", "fwfw@gmail.com"),
                new Student(2L, "Jack", "Cock", "123@ya.ru"),
                new Student(3L, "Amar", "Loskich", "losk_ich@test.com")
        ));

        Javalin app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/lessons", ctx -> {
            var search = ctx.queryParam("search");
            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("https")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();
            String safeHTML = policy.sanitize(search);

            List<Lesson> searchArr = arrLessons.stream()
                    .filter(elem -> {
                        if (elem.getNameLesson().startsWith(safeHTML) || elem.getDescription().startsWith(safeHTML)) {
                            return true;
                        }
                        return false;
                    })
                    .toList();

            var page = new LessonsPage(searchArr, safeHTML);
            ctx.render("layout/lessons/lessons.jte", model("page", page));
        });

        app.get("/lessons/{id}", ctx -> {
            var id = ctx.pathParam("id");
            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("https")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();
            String safeHTML = policy.sanitize(id);

            try {
                var page = new LessonPage(arrLessons.stream()
                        .filter(elem -> String.valueOf(elem.getId()).equals(safeHTML))
                        .findFirst()
                        .get());

                ctx.render("layout/lessons/lesson.jte", model("page", page));
            } catch (Exception e) {
                throw new NotFoundResponse("Not found this lesson");
            }
        });

        app.get("/students", ctx -> {
            var search = ctx.queryParam("search");
            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("https")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();
            String safeHTML = policy.sanitize(search);

            List<Student> searchArr = arrStudents.stream()
                    .filter(elem -> {
                        if (elem.getFirstName().startsWith(safeHTML) || elem.getLastName().startsWith(safeHTML)) {
                            return true;
                        }
                        return false;
                    })
                    .toList();

            var page = new StudentsPage(searchArr, safeHTML);
            ctx.render("layout/students/students.jte", model("page", page));
        });

        app.get("/students/{id}", ctx -> {
            var id = ctx.pathParam("id");
            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("https")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();
            String safeHTML = policy.sanitize(id);

            try {
                var page = new StudentPage(arrStudents.stream()
                        .filter(elem -> String.valueOf(elem.getId()).equals(safeHTML))
                        .findFirst()
                        .get());

                ctx.render("layout/students/student.jte", model("page", page));
            } catch (Exception e) {
                throw new NotFoundResponse("Not found this student");
            }
        });

        app.start(7070);
    }
}