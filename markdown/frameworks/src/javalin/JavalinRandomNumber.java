import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

public class JavalinRandomNumber {
    public static void main(String[] args) {
        String htmlIntButton = "<button><a href='./int'>Random Integer</a></button>";
        String htmlFloatButton = "<button><a href='./float'>Random Float</a></button>";
        String htmlShutdownButton = "<button><a href='./exit'>Shutdown</a></button>";
        String htmlButtons = htmlIntButton + htmlFloatButton + htmlShutdownButton;
        Logger logger = Logger.getLogger(JavalinRandomNumber.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        Javalin app = Javalin.create().start(8080);

        // Registirere eine Handler der aufgerufen wird, nachdem eine HTTP-Anfrage eingegangen ist
        // und bevor sie verarbeitet wurde.
        app.before(
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) throws Exception {
                        logger.log(Level.INFO, "Before " + ctx);
                    }
                });

        // Registirere eine Handler der aufgerufen wird, wenn eine HTTP-Anfrage auf
        // "localhost:8080/" eingeht.
        app.get(
                "/",
                new Handler() {
                    @Override
                    public void handle(Context ctx) throws Exception {
                        ctx.html("<p>Welcome!</p>" + htmlButtons);
                    }
                });

        // Registirere eine Handler der aufgerufen wird, wenn eine HTTP-Anfrage auf
        // "localhost:8080/int" eingeht.
        app.get(
                "/int",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) throws Exception {
                        ctx.html("<p>" + randomInt() + "</p>" + htmlButtons);
                    }
                });

        // Registirere eine Handler der aufgerufen wird, wenn eine HTTP-Anfrage auf
        // "localhost:8080/float" eingeht.
        app.get(
                "/float",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) throws Exception {
                        ctx.html("<p>" + randomFloat() + "</p>" + htmlButtons);
                    }
                });

        // Registirere eine Handler der aufgerufen wird, wenn eine HTTP-Anfrage auf
        // "localhost:8080/exit" eingeht.
        app.get(
                "/exit",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) throws Exception {
                        logger.log(Level.INFO, "Shut down!");
                        System.exit(0);
                    }
                });

        // Registirere eine Handler der aufgerufen wird, wenn eine HTTP-Anfrage abgearbeitet wurde.
        app.after(
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) throws Exception {
                        logger.log(Level.INFO, "After " + ctx);
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
