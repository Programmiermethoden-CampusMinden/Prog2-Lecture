package javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class JavalinHelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        //localhost:8080
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result("Hello World");
            }
        });
    }
}


