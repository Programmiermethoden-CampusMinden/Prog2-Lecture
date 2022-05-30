package nested;

/** Nur als Vorlage für die Folien ... */
public class Outer {
    private class Inner {}

    static class StaticNested {}

    /** Just to please Checkstyle :) */
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        Outer.StaticNested nested = new Outer.StaticNested();
    }
}
