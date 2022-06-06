package optional.traditional;

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

        Studi best = null;
        for (Studi s : sl) {
            if (best == null) best = s;
            if (best.credits() < s.credits()) best = s;
        }

        // Entweder Optional.empty() (wenn best==null) oder Optional.of(best) sonst
        return Optional.ofNullable(best);
    }
}
