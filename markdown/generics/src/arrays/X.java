package arrays;

class A {
    void printInfo() {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    void printInfo() {
        System.out.println("B");
    }
}

class C<T> {
    // private T t = new T(); // kein new für T aufrufbar
}

public class X {
    public static void printInfo(A[] list) {
        for (A a : list) {
            a.printInfo();
        }
    }

    public static void main(String[] args) {
        // Ein B ist auch ein A ...
        A[] a = { new A(), new B() };
        B[] b = { new B(), new B() };

        // Da B von A ableitet, darf man ein B[] statt eines A[] verwenden ...
        printInfo(a);
        printInfo(b);

        // Arrays besitzen Typinformationen über gespeicherte Elemente
        // Prüfung auf Typkompatibilität zur **Laufzeit** (nicht Kompilierzeit!)
        Object[] x = new String[] { "Hello", "World", ":-)" };
        x[0] = "Hallo";
        x[0] = new Double(2.0); // Laufzeitfehler
        // String[] y = x; // String[] ist KEIN Object[]!

        // Keine Arrays mit parametrisierten Klassen!
        C<String>[] strList; // Deklaration noch erlaubt
        // C<String>[] strList1 = new C<String>[2]; // Compilerfehler
        C<String[]> strList2 = new C<>(); // OK :)
    }
}
