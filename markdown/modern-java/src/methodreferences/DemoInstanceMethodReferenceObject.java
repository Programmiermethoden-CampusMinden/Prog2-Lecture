package methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Beispiel: Referenz auf Instanz-Methode (Objekt) */
public class DemoInstanceMethodReferenceObject {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();
        Studi holger = new Studi("Holger", 42);

        // Referenz auf Instanz-Methode eines Objekts
        Collections.sort(sl, holger::cmpCpsInstance);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> holger.cmpCpsInstance(o1, o2));
    }
}
