package methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Beispiel: Referenz auf statische Methode */
public class DemoStaticMethodReference {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Referenz auf statische Methode
        Collections.sort(sl, Studi::cmpCpsClass);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> Studi.cmpCpsClass(o1, o2));
    }
}
