package javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

/** Demo für Javalin: Hello World (MWE) */
public class JavalinHelloWorld {
    /** Starte die Demo */
    public static void main(String[] args) {
        // Starte den Webserver auf Port 8080: "localhost:8080/"
        Javalin app = Javalin.create().start(8080);

        // Registriere Handler für "localhost:8080/"
        app.get(
                "/",
                new Handler() {
                    // Context: https://javalin.io/documentation#context
                    @Override
                    public void handle(@NotNull Context ctx) {
                        ctx.result("Hello World");
                    }
                });

        // Registriere Handler für "localhost:8080/exit"
        app.get(
                "/exit",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) {
                        System.exit(0);
                    }
                });
    }
}
