package challenges.defaults;

public class Voegel {

    public interface Vogel {
        default void gleiten() {
            System.out.println("Mittlere Distanz gegleitet.");
        }
    }

    public interface Segler extends Vogel {
        default void gleiten() {
            System.out.println("Lange Distanz gegleitet");
        }
    }

    public static class Schornsteinsegler implements Vogel, Segler {}
}
