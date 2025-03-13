package com.example.controller;

import com.example.dto.students.BuildStudentPage;
import com.example.dto.students.StudentPage;
import com.example.dto.students.StudentsPage;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.util.Sanitizer;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class StudentsController {
    public static void index(Context ctx) {
        var search = ctx.queryParam("search");
        String safeHTML = Sanitizer.sanitize(search).toLowerCase().strip();

        List<Student> searchArr = StudentRepository.search(safeHTML);
        var page = new StudentsPage(searchArr, search, ctx.consumeSessionAttribute("flashStudent"));
        ctx.render("layout/students/students.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildStudentPage();
        ctx.render("layout/students/build.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParam("id");
        String safeHTML = Sanitizer.sanitize(id).toLowerCase().strip();

        try {
            var page = new StudentPage(StudentRepository.find(Long.parseLong(safeHTML)).orElseThrow());
            ctx.render("layout/students/student.jte", model("page", page));
        } catch (Exception e) {
            throw new NotFoundResponse("Not found this student");
        }
    }

    public static void create(Context ctx) {
        try {
            var firstName = ctx.formParamAsClass("firstName", String.class)
                    .check(elem -> elem.length() > 2, "First name has few characters")
                    .check(elem -> elem.length() < 50, "First name has many characters")
                    .get();

            var lastName = ctx.formParamAsClass("lastName", String.class)
                    .check(elem -> elem.length() > 2, "Last name has few characters")
                    .check(elem -> elem.length() < 50, "Last name has many characters")
                    .get();

            var email = ctx.formParamAsClass("email", String.class)
                    .check(elem -> elem.length() <= 100 ,"There are a lot of symbols in email")
                    .get();

            var safeFirstName = StringUtils.capitalize(Sanitizer.sanitize(firstName));
            var safeLastName = StringUtils.capitalize(Sanitizer.sanitize(lastName));
            var safeEmail = Sanitizer.sanitize(email).toLowerCase().strip();

            var student = new Student(safeFirstName, safeLastName, safeEmail);
            StudentRepository.save(student);
            ctx.sessionAttribute("flashStudent", "Student has been created!");
            ctx.redirect("/students");
        } catch (ValidationException e) {
            var fistName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var email = ctx.formParam("email");
            var page = new BuildStudentPage(fistName, lastName, email, e.getErrors());
            ctx.render("layout/students/build.jte", model("page", page));
        }
    }
}
