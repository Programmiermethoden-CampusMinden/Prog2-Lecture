package challenges.flyweight;

public class Position {
    public int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
            "X=" + x +
            ", Y=" + y +
            '}';
    }
}
