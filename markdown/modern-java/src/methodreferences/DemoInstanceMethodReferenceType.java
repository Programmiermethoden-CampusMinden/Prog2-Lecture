package methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Beispiel: Referenz auf Instanz-Methode (Typ) */
public class DemoInstanceMethodReferenceType {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Referenz auf Instanz-Methode eines Typs
        Collections.sort(sl, Studi::cmpCpsInstanz);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> o1.cmpCpsInstanz(o2));
    }
}
