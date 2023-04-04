package challenges;

public class Main {
    public static void main(String[] args) {
        Grosshandel ghandel = new Grosshandel();
        Einzelhandel handel1 = new Einzelhandel(ghandel);
        Einzelhandel handel2 = new Einzelhandel(ghandel);

        handel1.bestellen(new Auftrag(WarenTyp.Batterien, 2));
        handel1.bestellen(new Auftrag(WarenTyp.Bretter, 2));
        handel2.bestellen(new Auftrag(WarenTyp.Batterien, 2));
        handel2.bestellen(new Auftrag(WarenTyp.Farbeimer, 2));
        while (handel1.hatAuftraege() || handel2.hatAuftraege()) {
            ghandel.loop();
            handel1.loop();
            handel2.loop();
        }
    }
}
