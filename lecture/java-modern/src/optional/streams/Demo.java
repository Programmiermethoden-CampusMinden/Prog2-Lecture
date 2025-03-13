package optional.streams;

import java.util.NoSuchElementException;

/** Demo: Optional mit Streams */
public class Demo {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        LSF lsf = new LSF();

        Studi holger = new Studi("Holger", 7);
        Studi anne = new Studi("Anne", 42);

        lsf.anmelden(holger);
        lsf.anmelden(anne);

        try {
            // Hole Studi und löse den Namen auf oder NoSuchElementException
            String name = lsf.getBestStudi().map(Studi::name).orElseThrow();
            // mach was mit dem Namen ...
        } catch (NoSuchElementException nsee) {
            // Oops: Entweder der Rückgabewert von getBestStudi() war leer,
            // oder Studi::name hat null geliefert.
        } catch (NullPointerException npe) {
            // Oops: Es gab noch keine Sammlung ...
        } catch (Exception e) {
            // Oops: Etwas anderes Unerwartetes ist passiert ...
        }
    }
}
