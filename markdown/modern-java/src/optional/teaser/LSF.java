package optional.teaser;

import java.util.HashSet;
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
    public Studi getBestStudi() {
        if (sl == null) return null; // Fehler: Es gibt noch keine Liste

        Studi best = null;
        for (Studi s : sl) {
            if (best == null) best = s;
            if (best.credits() < s.credits()) best = s;
        }

        return best;
    }
}
