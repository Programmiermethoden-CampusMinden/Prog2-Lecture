package factory;

abstract class Ticket {
}

class KurzStrecke extends Ticket {
}

class SemesterTicket extends Ticket {
}

public class FactoryBeispiel {
    // private: kann von aussen nicht benutzt werden
    private FactoryBeispiel() {
    }

    // neue Objekte gibt es (nur) hiermit
    public static Ticket getTicket(String wunsch, int cent) {
        if (wunsch.matches("Kurz.*") && cent == 240) {
            return new KurzStrecke();
        }
        if (wunsch.matches("Sem.*|Studi.*") && cent == 5600) {
            return new SemesterTicket();
        }
        // Bad Smell: returning "null" instead of "Ticket"
        return null;
    }

    public static void main(String[] args) {
        Ticket bsp = FactoryBeispiel.getTicket("Kurz", 240);
        System.out.println(bsp);
    }
}
