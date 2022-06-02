package records;

/** Modellieren wir einen Studi (als Record) */
public record StudiS(String name, int credits) {
    public StudiS(String name, int credits) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        } else {
            this.name = name;
        }
        if (credits < 0) {
            this.credits = 0;
        } else {
            this.credits = credits;
        }
    }
}
