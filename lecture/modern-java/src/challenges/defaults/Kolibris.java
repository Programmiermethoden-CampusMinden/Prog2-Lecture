package challenges.defaults;

public class Kolibris {

    public interface Vogel {
        default void schweben() {
            System.out.println("Sehr starkes hin und her.");
        }
    }

    public interface Tropenvogel extends Vogel {
        default void schweben() {
            System.out.println("Immer noch sehr starkes hin und her.");
        }
    }

    public static class Kolibri implements Vogel {
        @Override
        public void schweben() {
            System.out.println("Fast perfekt auf der Stelle.");
        }
    }

    public static class Adlerschnabel extends Kolibri implements Vogel, Tropenvogel {}
}
