/** Package fuer Code-Snippets in VL "Annotationen" */
package annotations;

/**
 * Summary fuer Klasse B
 *
 * <p>Wozu, warum, wieso :) Wozu, warum, wieso :) Wozu, warum, wieso :) Wozu, warum, wieso :)
 *
 * @author Carsten Gips
 */
public class B extends A {

    /**
     * Kleines Testprogramm zur Demonstration von Annotationen
     *
     * @param args CLI-Parameter für main()
     */
    public static void main(String[] args) {
        B s = new B();

        System.out.println(s.getInfo());
        System.out.println(s.getInfo("Info: "));
    }

    /**
     * Liefert Info zu Klasse B zurück
     *
     * <p>Methode ueberschreibt {@link A#getInfo()} und erweitert Parameter-String mit Zeichenkette
     * "Klasse B" ... Ausfuehrliche Beschreibung, die spaeter im Abschnitt "Method Detail"
     * erscheint, aber nicht in der Uebersicht.
     *
     * @param s String, der verarbeitet werden soll
     * @return neuer String
     * @see A#getInfo()
     * @see java.util.Date
     */
    // @Override
    public String getInfo(String s) {
        return s + "Klasse B";
    }
}
