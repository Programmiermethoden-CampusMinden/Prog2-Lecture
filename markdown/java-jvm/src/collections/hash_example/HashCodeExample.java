package hash_example;

import java.util.HashMap;

public class HashCodeExample {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2, "Punkt 1");
        Point p2 = new Point(1, 2, "Punkt 2");
        Point p3 = new Point(2, 1, "Punkt 3");

        // equals und hashCode
        System.out.println(p1.equals(p2)); // nur true, wenn equals ueberschrieben wurde
        System.out.println(
                p1.hashCode() == p2.hashCode()); // sicher true, wenn hashCode ueberschrieben wurde
        System.out.println(p1.equals(p3)); // false
        System.out.println(
                p1.hashCode() == p3.hashCode()); // obwohl equals false ist, kann der hashCode
        // indentisch sein

        // HashMap Example
        HashMap<Point, Integer> besucht = new HashMap<>();

        besucht.put(p1, 3);
        System.out.println(besucht.get(p1)); // 3
        System.out.println(besucht.get(p2)); // auch 3
        besucht.put(p2, 5);
        besucht.put(p3, 12);
        besucht.forEach((k, v) -> System.out.println(k.name() + ": " + v));
    }
}
