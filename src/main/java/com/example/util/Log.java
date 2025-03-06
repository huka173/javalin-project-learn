package com.example.util;

import io.javalin.http.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static void log(Context ctx) {
        System.out.println();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd', время' hh:mm:ss a zzz");

        System.out.println("Текущая дата: " + formatForDateNow.format(dateNow));
        System.out.println("Ip: " + ctx.ip());
        System.out.println("Path: " + ctx.path());
        System.out.println("Method: " + ctx.method());
        System.out.println("Тело запроса: " + ctx.body());
        System.out.println();
    }
}
