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
    public static String lessonPath(Long id) {
        return lessonPath(String.valueOf(id));
    }

    public static String lessonPath(String id) {
        return "/lessons/" + id;
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
    public static String studentPath(Long id) {
        return studentPath(String.valueOf(id));
    }

    public static String studentPath(String id) {
        return "/students/" + id;
    }

    public static String sessionsBuildPath() {
        return "/sessions/build";
    }

    public static String sessionsPath() {
        return "/sessions";
    }
}
