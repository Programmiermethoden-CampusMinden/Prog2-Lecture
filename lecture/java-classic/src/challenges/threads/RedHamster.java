package threads;

import java.util.stream.IntStream;

public record RedHamster(String name, Tunnel tunnel) implements Hamster {

    public void idle() {
        IntStream.range(0, 5).forEach(i -> System.out.println(name() + ": (red) wandering idly"));
    }

    public void moveThroughTunnel() {
        System.out.println(name() + ": => (red) entering tunnel");
        tunnel().enter(this);
        System.out.println(name() + ": => (red) entered tunnel");

        IntStream.range(0, 2)
                .forEach(i -> System.out.println(name() + ": (red) moving through tunnel"));

        System.out.println(name() + ": (red) leaving tunnel =>");
        tunnel().leave(this);
        System.out.println(name() + ": (red) left tunnel =>");
    }
}
