package com.example.routes;

public class NamedRoutes {

    // Маршрут главной страницы
    public static String homePath() {
        return "/";
    }

    // Маршрут вывода всех уроков
    public static String lessonsPath() {
        return "/lessons";
    }

    // Маршрут создания урока
    public static String lessonsBuildPath() {
        return "/lessons/build";
    }

    // Маршрут вывода конкретного урока
    public static String lessonPath() {
        return "/lessons/{id}";
    }

    // Маршрут вывода всех студентов
    public static String studentsPath() {
        return "/students";
    }

    // Маршрут создания студента
    public static String studentsBuildPath() {
        return "/students/build";
    }

    // Маршрут вывода конкретного студента
    public static String studentPath() {
        return "/students/{id}";
    }
}
