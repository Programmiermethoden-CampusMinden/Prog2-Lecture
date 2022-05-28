package defaultmethods.rule2;

interface A {
    default String hello() {
        return "A";
    }
}

interface B extends A {
    @Override
    default String hello() {
        return "B";
    }
}

interface C extends B {
    @Override
    default String hello() {
        return "C";
    }
}

class D implements A, B {}

/** Auflösung Mehrfachvererbung: 2. Sub-Interfaces gewinnen */
public class DefaultTest2 {
    /** Starter - just to please Checkstyle ;-) */
    public static void main(String... args) {
        String e = new D().hello();
    }
}
