package threads;

import java.util.stream.IntStream;

public record BlueHamster(String name, Tunnel tunnel) implements Hamster {

    public void idle() {
        IntStream.range(0, 5).forEach(i -> System.out.println(name() + ": (blue) wandering idly"));
    }

    public void moveThroughTunnel() {
        System.out.println(name() + ": => (blue) entering tunnel");
        tunnel().enter(this);
        System.out.println(name() + ": => (blue) entered tunnel");

        IntStream.range(0, 2)
                .forEach(i -> System.out.println(name() + ": (blue) moving through tunnel"));

        System.out.println(name() + ": (blue) leaving tunnel =>");
        tunnel().leave(this);
        System.out.println(name() + ": (blue) left tunnel =>");
    }
}
