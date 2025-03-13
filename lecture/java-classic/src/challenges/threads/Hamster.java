package threads;

public interface Hamster extends Runnable {
    String name();

    Tunnel tunnel();

    void idle();

    void moveThroughTunnel();

    @Override
    default void run() {
        idle();
        moveThroughTunnel();
        idle();
    }
}
