package javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavalinRandomNumber {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(RandomNumber.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        Javalin app = Javalin.create().start(8080);

        app.before(new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                logger.log(Level.INFO,"Before " + ctx);
            }
        });

        app.get("/", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                ctx.result("Welcome to the random number generator.");
            }
        });

        app.get("/int", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result(randomInt());
            }
        });

        app.get("/float", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result(randomFloat());
            }
        });

        app.after(new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                logger.log(Level.INFO,"After " + ctx);
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

