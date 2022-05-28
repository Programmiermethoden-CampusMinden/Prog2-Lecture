package defaultmethods.quiz;

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

class C implements B {
    @Override
    public String hello() {
        return "C";
    }
}

class D extends C implements A, B {}

/** Quiz Mehrfachvererbung */
public class DefaultTest {
    /** Starter - just to please Checkstyle ;-) */
    public static void main(String... args) {
        String e = new D().hello(); // ???
    }
}
