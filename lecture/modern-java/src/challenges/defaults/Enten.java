package challenges.defaults;

public class Enten {

    public interface Flugvogel {
        default void fortbewegen() {
            System.out.println("Fliegt durch die Luft.");
        }
    }

    public interface Wasservogel {
        default void fortbewegen() {
            System.out.println("Schwimmt im Wasser.");
        }
    }

    public static class Ente implements Flugvogel, Wasservogel {
        @Override
        public void fortbewegen() {
            Flugvogel.super.fortbewegen();
        }
    }
}
