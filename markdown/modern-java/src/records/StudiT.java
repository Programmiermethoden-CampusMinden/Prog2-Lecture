package records;

/** Modellieren wir einen Studi (als Record) */
public record StudiT(String name, int credits) {
    public StudiT {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
        if (credits < 0) {
            credits = 0;
        }
    }

    public StudiT() {
        this("", 42);
    }

    public int credits() {
        return credits + 42;
    }

    public void wuppie() {
        System.out.println("WUPPIE");
    }

    public void nope() {
        // credits = credits + 42;  // Nicht erlaubt!
    }
}
