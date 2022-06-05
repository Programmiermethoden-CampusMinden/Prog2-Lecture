package optional.traditional;

/** Demo: Verwendung von Optional mit direktem Zugriff */
public class Demo {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        LSF lsf = new LSF();

        Studi holger = new Studi("Holger", 7);
        Studi anne = new Studi("Anne", 42);

        lsf.anmelden(holger);
        lsf.anmelden(anne);

        Studi best;

        // Testen und dann verwenden
        if (!lsf.getBestStudi().isEmpty()) {
            best = lsf.getBestStudi().get();
            // mach was mit dem Studi ...
        }

        // Arbeite mit Consumer
        lsf.getBestStudi()
                .ifPresent(
                        s -> {
                            // mach was mit dem Studi ...
                        });

        // Studi oder Alternative (wenn Optional.empty())
        best = lsf.getBestStudi().orElse(anne);

        // Studi oder NoSuchElementException (wenn Optional.empty())
        best = lsf.getBestStudi().orElseThrow();
    }
}
