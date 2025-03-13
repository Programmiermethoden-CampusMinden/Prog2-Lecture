package threads;

public class Tunnel {
    private static final Tunnel tunnel = new Tunnel();

    private Tunnel() {}

    public static Tunnel get() {
        return tunnel;
    }

    public void enter(Hamster hamster) {
        System.out.println("\ttunnel: " + hamster.name() + ": in");
    }

    public void leave(Hamster hamster) {
        System.out.println("\ttunnel: " + hamster.name() + ": cleared");
    }
}
