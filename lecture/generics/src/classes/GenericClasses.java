package classes;

class Tutor<T> {
    // T kann in Klasse Tutor *fast* wie Klassenname verwendet werden
    private T x;

    public T foo(T t) {
        System.out.println("Tutor#foo");
        return t;
    }
}

public class GenericClasses {
    public static void main(String[] args) {
        Tutor<String> a = new Tutor<String>();
        Tutor<Integer> b = new Tutor<>(); // seit Java 1.7: "Diamond Operator"

        a.foo("wuppie");
        b.foo(1);
        // b.foo("huhu"); // Fehlermeldung vom Compiler
    }
}
