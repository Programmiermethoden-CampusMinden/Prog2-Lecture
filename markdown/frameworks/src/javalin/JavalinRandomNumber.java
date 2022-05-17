package javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class JavalinRandomNumber {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        //before each request
        app.before(new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                System.out.println("Before " + ctx);
            }
        });

        //localhost:8080
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result("Welcome to the random number generator.");
            }
        });

        //localhost:8080/int
        app.get("/int", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result(randomInt());
            }
        });

        //localhost:8080/float
        app.get("/float", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result(randomFloat());
            }
        });

        //after each request
        app.after(new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                System.out.println("After " + ctx);
            }
        });
    }


    public static String randomInt() {
        Random r = new Random();
        return "" + r.nextInt();
    }

    public static String randomFloat() {
        Random r = new Random();
        return "" + r.nextFloat();
    }
}
