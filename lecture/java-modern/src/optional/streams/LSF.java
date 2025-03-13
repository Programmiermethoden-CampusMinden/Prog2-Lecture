package optional.streams;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/** Modellierung des LSF */
public class LSF {
    private final Set<Studi> sl = new HashSet<>();

    /** Anmelden eines Studis */
    public boolean anmelden(Studi s) {
        return sl.add(s);
    }

    /** Abmelden eines Studis */
    public boolean abmelden(Studi s) {
        return sl.remove(s);
    }

    /** Finde den Studi mit den meisten Credits */
    public Optional<Studi> getBestStudi() throws NullPointerException {
        // Fehler: Es gibt noch keine Sammlung
        if (sl == null) throw new NullPointerException("There ain't any collection");

        return sl.stream().sorted((s1, s2) -> s2.credits() - s1.credits()).findFirst();
    }
}
