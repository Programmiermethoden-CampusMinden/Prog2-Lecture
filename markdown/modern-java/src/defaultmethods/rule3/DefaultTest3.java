package defaultmethods.rule3;

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

interface C extends B {
    @Override
    default String hello() {
        return "C";
    }
}

class D implements A, B {
    @Override
    public String hello() {
        return A.super.hello();
    }
}

/** Auflösung Mehrfachvererbung: 3. Methode explizit auswählen */
public class DefaultTest3 {
    /** Starter - just to please Checkstyle ;-) */
    public static void main(String... args) {
        String e = new D().hello();
    }
}
