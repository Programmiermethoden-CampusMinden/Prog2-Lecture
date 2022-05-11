package reflection;

import java.lang.reflect.Method;

public class Studi {
    private final String name;

    public Studi() {
        this("");
    }

    public Studi(String name) {
        this.name = name;
    }

    public static void main(String[] argv) {
        // usual way of life
        Studi heiner = new Studi();
        heiner.hello();

        // let's use reflection
        try {
            Object eve = Studi.class.getDeclaredConstructor().newInstance();
            Method m = Studi.class.getDeclaredMethod("hello");
            m.invoke(eve);
        } catch (ReflectiveOperationException ignored) {
            // TODO: Hier fehlt eine vernünftige Fehlerbehandlung!
        }
    }

    public String getName() {
        return name;
    }

    @Wuppie
    private String hello() {
        System.out.println("hello world :)");
        return name;
    }

    @Override
    @Wuppie
    public String toString() {
        return "Mein Name ist: '" + getName() + "'";
    }
}
