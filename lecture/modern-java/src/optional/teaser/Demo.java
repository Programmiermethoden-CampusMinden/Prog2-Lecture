package optional.teaser;

/** Teaser für die Folien */
public class Demo {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        LSF lsf = new LSF();

        Studi holger = new Studi("Holger", 7);
        Studi anne = new Studi("Anne", 42);

        lsf.anmelden(holger);
        lsf.anmelden(anne);

        Studi best = lsf.getBestStudi();
        if (best != null) {
            // mach was mit dem Studi ...
            String name = best.name();
            if (name != null) {
                // mach was mit dem Namen ...
            }
        }
    }
}
