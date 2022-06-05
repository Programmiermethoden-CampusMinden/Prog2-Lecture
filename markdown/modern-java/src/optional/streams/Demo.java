package optional.streams;

/** Demo: Optional mit Streams */
public class Demo {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        LSF lsf = new LSF();

        Studi holger = new Studi("Holger", 7);
        Studi anne = new Studi("Anne", 42);

        lsf.anmelden(holger);
        lsf.anmelden(anne);

        // Hole Studi und löse den Namen auf oder NoSuchElementException
        // anna.name == null => NoSuchElementException
        // anna.name != null => "Anna"
        String name = lsf.getBestStudi().map(Studi::name).orElseThrow();
    }
}
