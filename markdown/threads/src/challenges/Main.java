package challenges;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int KUNDEN = 4;

    public static void main(String[] args) {
        // Kunden erstellen
        List<Kunde> kunden = new ArrayList<>();
        for (int i = 0; i < KUNDEN; i++) {
            kunden.add(new Kunde());
        }
        // Threads starten
        for (Kunde k : kunden) {
            new Thread(k).start();
            new Thread(new Geldeintreiber(k, kunden)).start();
        }
    }
}
