package nested;

@FunctionalInterface
interface Fluppie<T> {
    int fluppie(T obj);
}

class MyStudi extends Studi {
    /**
     * Konstruktor: Baue einen neuen Studi
     *
     * @param name Name des neuen Studis
     * @param credits Credits des neuen Studis
     */
    public MyStudi(String name, int credits) {
        super(name, credits);
    }

    /** Methode mit einem funktionalen Interface als Parameter */
    public int foo(Fluppie<MyStudi> w) {
        return w.fluppie(this);
    }
}

/** Demo für ein eigenes funktionales Interface */
public class DemoFunctionalInterface {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        MyStudi s = new MyStudi("Harald", 42);

        s.foo(
                new Fluppie<MyStudi>() {
                    @Override
                    public int fluppie(MyStudi o) {
                        return o.getCredits();
                    }
                });

        s.foo((o) -> o.getCredits());
        s.foo((o) -> o.getName().length());
        s.foo(
                (o) -> {
                    return o.getName().length();
                });
    }
}
