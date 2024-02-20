package challenges.optional;

import java.util.ArrayList;
import java.util.List;

public class KatzenCafe {
    private List<Katze> katzen;

    /**
     * Füge eine Katze dem Café hinzu
     *
     * @param katze
     */
    public void addKatze(Katze katze) {
        if (katze == null) return;
        if (katzen == null) katzen = new ArrayList<>();
        katzen.add(katze);
    }

    /**
     * @param minGewicht Gewicht Untergrenze
     * @param maxGewicht Gewicht Obergrenze
     * @return Die erste Katze im Café, deren Gewicht zwischen den Werten liegt
     */
    public Katze getKatzeByGewicht(float minGewicht, float maxGewicht) {
        if (katzen == null) return null;
        if (minGewicht < 0) return null;
        if (maxGewicht < minGewicht) return null;
        for (Katze k : katzen) {
            if (k.gewicht() >= minGewicht && k.gewicht() < maxGewicht) return k;
        }
        return null;
    }

    /**
     * @param box Box zu der die passenden Katzen gesucht werden
     * @return Alle Café-Katzen, deren Lieblingsbox übergeben wurde
     */
    public List<Katze> getKatzenZurBox(Box box) {
        if (katzen == null) return null;
        if (box == null) return null;
        List<Katze> katzenZurBox = new ArrayList<>();
        for (Katze k : katzen) {
            if (k.lieblingsBox() != null) {
                if (k.lieblingsBox().equals(box)) {
                    katzenZurBox.add(k);
                }
            }
        }
        return katzenZurBox;
    }

    public static void main(String[] args) {
        KatzenCafe cafe = new KatzenCafe();
        
        Katze greebo = cafe.getKatzeByGewicht(10, 20);
        if (greebo != null) System.out.println(greebo.name());

        Box box = new Box(5, 5, 5, Material.KARTON);
        List<Katze> katzen = cafe.getKatzenZurBox(box);
        if (katzen != null) {
            for (Katze k : katzen) {
                if (k != null) {
                    System.out.println(k.name());
                }
            }
        }
    }
}
