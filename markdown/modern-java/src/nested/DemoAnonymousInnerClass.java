package nested;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Sortieren einer Liste mit einer anonymen inneren Klasse */
public class DemoAnonymousInnerClass {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<>();

        // Parametrisierung mit anonymer Klasse
        sl.sort(
                new Comparator<Studi>() {
                    @Override
                    public int compare(Studi o1, Studi o2) {
                        return o1.getCredits() - o2.getCredits();
                    }
                });
    }
}
