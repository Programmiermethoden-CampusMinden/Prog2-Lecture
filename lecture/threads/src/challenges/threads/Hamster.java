package threads;

import java.util.stream.IntStream;

public interface Hamster extends Runnable {
    String name();

    Tunnel tunnel();

    default void idle() {
        IntStream.range(0, 5).forEach(i -> System.out.println(name() + ": wandering idly"));
    }

    default void moveThroughTunnel() {
        System.out.println(name() + ": => entering tunnel");
        tunnel().enter(this);
        System.out.println(name() + ": => entered tunnel");

        IntStream.range(0, 2).forEach(i -> System.out.println(name() + ": moving through tunnel"));

        System.out.println(name() + ": leaving tunnel =>");
        tunnel().leave(this);
        System.out.println(name() + ": left tunnel =>");
    }

    @Override
    default void run() {
        idle();
        moveThroughTunnel();
        idle();
    }
}
