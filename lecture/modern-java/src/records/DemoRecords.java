package records;

/** Studi: Klasse vs. Record */
public class DemoRecords {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        Studi s = new Studi("Holger", 42);
        StudiR r = new StudiR("Sabine", 75);

        int x = r.credits();
        String y = r.name();

        StudiT t = new StudiT("ugh", 1);
        int credits = t.credits();
        t.wuppie();
    }
}
