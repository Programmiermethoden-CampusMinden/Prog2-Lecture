package nested;

/** Nur als Vorlage für die Folien ... */
public class Outer {
    /** Just to please Checkstyle :) */
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        Outer.StaticNested nested = new Outer.StaticNested();
    }

    static class StaticNested {}

    private class Inner {}
}
