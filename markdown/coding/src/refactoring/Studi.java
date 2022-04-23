package refactoring;

public class Studi extends Person {
    public String n;
    public int c;
    public Kurs k;

    Studi(String name, int cps, Kurs kurs) {
        n = name;
        c = cps;
        k = kurs;
    }

    public static void main(String[] args) {
        Kurs k = new Kurs("toller Kurs", 9);
        Studi s = new Studi("Holger", 2, k);
        s.n = "Heini";
        s.prtIf();
    }

    public void prtIf() {
        // Kopfzeile ausgeben
        System.out.println("==================");
        System.out.println("= Infos zu Studi =");
        System.out.println("==================");

        // Details zum Studis ausgeben
        System.out.println("name:    " + n);
        System.out.println("credits: " + c);

        // Details zum besuchten Kurs ausgeben
        System.out.println("Kurs:    " + k.descr);
        System.out.println("Credits: " + k.cps);

        // Kopfzeile ausgeben
        System.out.println("==================");
    }
}
