package threads;

public class Main {
    public static void main(String... args) {
        Tunnel tunnel = Tunnel.get();

        Hamster bh1 = new BlueHamster("blue1", tunnel);
        Hamster bh2 = new BlueHamster("blue2", tunnel);
        Hamster bh3 = new BlueHamster("blue3", tunnel);

        Hamster rh1 = new RedHamster("red1", tunnel);
        Hamster rh2 = new RedHamster("red2", tunnel);

        new Thread(bh1).start();
        new Thread(bh2).start();
        new Thread(bh3).start();
        new Thread(rh1).start();
        new Thread(rh2).start();
    }
}
