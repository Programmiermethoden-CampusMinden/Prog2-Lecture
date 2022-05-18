package javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class JavalinHelloWorld {
    public static void main(String[] args) {
        //Starte den Webserver auf Port 8080
        Javalin app = Javalin.create().start(8080);

        //Registirere eine Handler der aufgerufen wird, wenn eine HTTP-Anfrage auf "localhost:8080/" eingeht.
        app.get("/", new Handler() {
            @Override
            //Context: https://javalin.io/documentation#context
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result("Hello World");
            }
        });
    }
}

