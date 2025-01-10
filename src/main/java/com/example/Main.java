package com.example;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> {
            ctx.result("Hello, this is a users page");
        });

        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");

            if (ctx.queryParamMap().size() == 0) {
                ctx.result("Hello, World!");
            } else {
                if (name.isEmpty()) {
                    ctx.result("Hello, World!");
                } else {
                    ctx.result("Hello, " + name + "!");
                }
            }

            System.out.println(name);
        });

        app.start(7070);
    }
}