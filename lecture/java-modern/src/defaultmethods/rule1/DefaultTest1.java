package defaultmethods.rule1;

interface A {
    default String hello() {
        return "A";
    }
}

interface B {
    default String hello() {
        return "B";
    }
}

class C implements A {
    @Override
    public String hello() {
        return "C";
    }
}

class D {
    public String hello() {
        return "D";
    }
}

class E extends C implements A, B {}

/** Auflösung Mehrfachvererbung: 1. Klassen gewinnen */
public class DefaultTest1 {
    /** Starter - just to please Checkstyle ;-) */
    public static void main(String... args) {
        String e = new E().hello();
    }
}
