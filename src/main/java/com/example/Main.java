package com.example;

import com.example.dto.lessons.LessonPage;
import com.example.dto.lessons.LessonsPage;
import com.example.dto.students.StudentPage;
import com.example.dto.students.StudentsPage;
import com.example.model.Lesson;
import com.example.model.Student;
import com.example.repository.LessonRepository;
import com.example.repository.StudentRepository;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
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
            PolicyFactory policy = new HtmlPolicyBuilder()
                    .allowElements("a")
                    .allowUrlProtocols("https")
                    .allowAttributes("href").onElements("a")
                    .requireRelNofollowOnLinks()
                    .toFactory();
            String safeHTML = policy.sanitize(search).toLowerCase();

            List<Lesson> searchArr = LessonRepository.search(safeHTML);
            var page = new LessonsPage(searchArr, search);
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
                var page = new LessonPage(LessonRepository.find(Long.parseLong(safeHTML)).get());
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
            String safeHTML = policy.sanitize(search).toLowerCase();

            List<Student> searchArr = StudentRepository.search(safeHTML);
            var page = new StudentsPage(searchArr, search);
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
                var page = new StudentPage(StudentRepository.find(Long.parseLong(safeHTML)).get());
                ctx.render("layout/students/student.jte", model("page", page));
            } catch (Exception e) {
                throw new NotFoundResponse("Not found this student");
            }
        });

        app.start(7070);
    }
}