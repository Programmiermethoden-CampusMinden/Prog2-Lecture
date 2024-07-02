package threads;

public class Main {
    public static void main(String... args) {
        Tunnel tunnel = Tunnel.get();

        Hamster bh1 = new BlueHamster("bh1", tunnel);
        Hamster bh2 = new BlueHamster("bh2", tunnel);
        Hamster bh3 = new BlueHamster("bh3", tunnel);

        Hamster rh1 = new RedHamster("rh1", tunnel);
        Hamster rh2 = new RedHamster("rh2", tunnel);

        new Thread(bh1).start();
        new Thread(bh2).start();
        new Thread(bh3).start();
        new Thread(rh1).start();
        new Thread(rh2).start();
    }
}
