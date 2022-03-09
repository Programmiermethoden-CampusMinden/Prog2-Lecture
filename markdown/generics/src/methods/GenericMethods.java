package methods;

class Mensch {
    public <T> T myst(T m, T n) {
        System.out.println("X#myst: T");
        return m;
    }

    // NICHT erlaubt wg.Typ-Löschung:
/*
    public <T1, T2> T1 myst(T1 m, T2 n) {
        System.out.println("X#myst: T");
        return m;
    }
 */

    public String myst(String m, String n) {
        System.out.println("X#myst: String");
        return m;
    }

    public int myst(int m, int n) {
        System.out.println("X#myst: int");
        return m;
    }
}

public class GenericMethods {
    public static void main(String[] args) {
        Mensch m = new Mensch();

        m.<String>myst("Essen", "lecker"); // Angabe Typparameter

        m.myst("Essen", 1); // String, Integer => T: Object
        m.myst("Essen", "lecker"); // String, String => T: String
        m.myst(1.0, 1); // Double, Integer => T: Number

        // Integer i = m.myst(1.0, 1); // Fehler!!!
        // Double d = m.myst(1.0, 1); // Fehler!!!
        Number n = m.myst(1.0, 1); // Double, Integer => T: Number

        m.myst(3, 4);
        m.myst(m, m);
        m.myst(m, 1);
    }
}
