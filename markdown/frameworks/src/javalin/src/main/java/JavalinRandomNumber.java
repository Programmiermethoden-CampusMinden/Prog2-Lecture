import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.Random;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

/** Demo für Javalin: Erzeuge Zufallszahlen */
public class JavalinRandomNumber {
    static final Logger LOGGER = Logger.getLogger(JavalinRandomNumber.class.getName());

    static final String HTML_BUTTONS =
            "<button><a href='./int'>Random Integer</a></button>"
                    + "<button><a href='./float'>Random Float</a></button>"
                    + "<button><a href='./exit'>Shutdown</a></button>";

    /** Starte die Demo */
    public static void main(String[] args) {

        // Starte den Webserver auf Port 8080: "localhost:8080/"
        Javalin app = Javalin.create().start(8080);

        // Registriere Handler für "localhost:8080/"
        handleRoot(app);

        // Registriere Handler "localhost:8080/int"
        handleInt(app);

        // Registriere Handler für "localhost:8080/float"
        handleFloat(app);

        // Registriere Handler für "localhost:8080/exit"
        handleExit(app);
    }

    private static void handleExit(Javalin app) {
        app.get(
                "/exit",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) {
                        LOGGER.info("Shut down!");
                        System.exit(0);
                    }
                });
    }

    private static void handleFloat(Javalin app) {
        app.get(
                "/float",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) {
                        ctx.html("<p>" + randomFloat() + "</p>" + HTML_BUTTONS);
                    }
                });
    }

    private static void handleInt(Javalin app) {
        app.get(
                "/int",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) {
                        ctx.html("<p>" + randomInt() + "</p>" + HTML_BUTTONS);
                    }
                });
    }

    private static void handleRoot(Javalin app) {
        app.get(
                "/",
                new Handler() {
                    @Override
                    public void handle(@NotNull Context ctx) {
                        ctx.html("<p>Welcome!</p>" + HTML_BUTTONS);
                    }
                });
    }

    private static String randomInt() {
        Random r = new Random();
        return "" + r.nextInt();
    }

    private static String randomFloat() {
        Random r = new Random();
        return "" + r.nextFloat();
    }
}
