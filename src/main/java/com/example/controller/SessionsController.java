package com.example.controller;

import com.example.util.Sanitizer;
import io.javalin.http.Context;

public class SessionsController {
    public static void build(Context ctx) {
        ctx.render("layout/sessions/build.jte");
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("nickname");
        var checkNick = Sanitizer.sanitize(nickname);
        ctx.sessionAttribute("nickname", checkNick);
        ctx.redirect("/");
    }
}
