package challenges;

public class Bank {

    /**
     * Ueberweise Geld von einem Konto auf das andere
     *
     * @param von Konto von dem das Geld gesendet wird
     * @param rechnung Die Rechnung die bezahlt werden muss
     */
    public static void ueberweisen(Konto von, Rechnung rechnung) {
        Transaktion transaktion = new Transaktion(von, rechnung);
        transaktion.doTransaktion();
    }
}
