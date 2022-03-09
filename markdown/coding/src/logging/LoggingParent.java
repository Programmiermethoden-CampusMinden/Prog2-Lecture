package logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingParent {
    private static final Logger logA = Logger.getLogger("b.a");
    private static final Logger logB = Logger.getLogger("b");
    private static final Logger logBase = Logger.getLogger("");

    public static void main(String[] argv) {
        System.out.println("B ist Eltern von A: " + (logA.getParent() == logB));
        System.out.println("'' ist Eltern von B:  " + (logB.getParent() == logBase));

        logA.setLevel(Level.FINE);
        logB.setLevel(Level.SEVERE);
//        logBase.setLevel(Level.SEVERE);

        System.out.println("Log-Level A: " + logA.getLevel());
        System.out.println("Log-Level B: " + logB.getLevel());
        System.out.println("Log-Level Basis: " + logBase.getLevel());
        System.out.println("Log-Level Basis-Handler[0]: " + logBase.getHandlers()[0].getLevel());
//        logBase.getHandlers()[0].setLevel(Level.FINE);
//        logBase.getHandlers()[0].setLevel(Level.SEVERE);
//        logA.setUseParentHandlers(false);
//        logB.setUseParentHandlers(false);

        ConsoleHandler handlerA = new ConsoleHandler();
        handlerA.setLevel(Level.ALL);
        handlerA.setFormatter(new MyFormatter("A"));
        logA.addHandler(handlerA);

        ConsoleHandler handlerB = new ConsoleHandler();
        handlerB.setLevel(Level.ALL);
        handlerB.setFormatter(new MyFormatter("B"));
        logB.addHandler(handlerB);

        logA.finest("A: level finest");
        logA.fine("A: level fine");
        logA.info("A: level info");
        logA.warning("A: level warning");
        logA.severe("A: level severe");
    }
}
