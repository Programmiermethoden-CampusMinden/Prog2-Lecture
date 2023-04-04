package challenges.command;

public final class Position {
    public int x, y;

    /**
     * Basis Konstruktor welcher x und y mit 0 initialisiert
     */
    public Position() {
        this(0, 0);
    }

    /**
     * Konstruktor welcher x und y mit den angegebenen Werten initialisiert.
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Erstellt eine String representation von dem Position Objekt im Format [x={x}, y={y}].
     * @return die String representation
     */
    @Override
    public String toString() {
        return "[" + "x=" + x + ", y=" + y + ']';
    }
}
